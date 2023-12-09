package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class orderscontrol {
	
	public void navigateback(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.Homepage();
	}
	public void navigateorders(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.orders();
	}
	public void navigateupdate(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.updateorder();
	}
	

	@FXML
    private TextField updateorderid;
	
    @FXML
    private TableView<orders> orderTable;

    @FXML
    private TableColumn<orders, Integer> orderIDColumn;

    @FXML
    private TableColumn<orders, Integer> productIDColumn;

    @FXML
    private TableColumn<orders, String> orderStatusColumn;

    @FXML
    private TableColumn<orders, Integer> orderQuantityColumn;

    @FXML
    private TableColumn<orders, String> productNameColumn;
    
    database database = new database();

    public void initialize() {
        try {
            // Set up the cell value factories for each column
            orderIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOrder_id()).asObject());
            productIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProduct_id()).asObject());
            orderStatusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOrder_status()));
            orderQuantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOrder_quantity()).asObject());
            productNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct_name()));

            List<orders> orderList = getOrdersFromDatabase();

            orderTable.setItems(FXCollections.observableArrayList(orderList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<orders> getOrdersFromDatabase() {
        List<orders> orderList = new ArrayList<>();

        
        String selectQuery = "SELECT oi.order_id, oi.product_id, oi.order_quantity, oi.order_status, pd.product_name FROM order_info oi JOIN payment p ON oi.order_id = p.order_id JOIN products pd ON oi.product_id = pd.product_id WHERE oi.order_status = 'No'";
        
//        String selectQuery="SELECT oi.order_id, oi.product_id, oi.order_quantity, oi.order_status, pd.product_name FROM order_info oi JOIN payment p ON oi.order_id = p.order_id JOIN products pd";


        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(selectQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int order_id = resultSet.getInt("order_id");
                    int product_id = resultSet.getInt("product_id");
                    String order_status = resultSet.getString("order_status");
                    int order_quantity = resultSet.getInt("order_quantity");
                    String product_name = resultSet.getString("product_name");

                    orders order = new orders(order_id, product_id, order_status, order_quantity, product_name);
                    orderList.add(order);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
            }catch(Exception e) {
            	e.printStackTrace();
            }
            return orderList;
        } 
    
    public void updateOrders(MouseEvent event) {
        String updateQuery = "UPDATE order_info SET order_status = 'Yes' WHERE order_id = ?";
        
        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, Integer.parseInt(updateorderid.getText()));
            int result = preparedStatement.executeUpdate();
            
            System.out.println(result + " Rows affected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        
    }
