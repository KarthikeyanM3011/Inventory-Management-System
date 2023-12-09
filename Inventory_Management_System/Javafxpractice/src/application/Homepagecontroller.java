package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class Homepagecontroller extends Products {
    @FXML
    private Text u_name;

    public void setUserName(String name) {
        u_name.setText(name);
    }
    
    public void addprod(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.Addproduct();
    }
    
    public void navigateBack(MouseEvent event) {
    	Main.cstage.setScene(Main.homescene);
    }
    
    public void updateproduct(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.Updateproduct();
    }
    
    public void removeproduct(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.Removeproduct();
    }
  
    public static List<Products> getAllProducts() {
    	database database = new database();
        List<Products> productsList = new ArrayList<>();
        String selectQuery="SELECT p.product_id,p.product_name,p.product_price,p.product_description,s.available_stock,COALESCE(o.available_orders, 0) AS available_orders FROM (products p NATURAL JOIN stocks s) LEFT JOIN (SELECT p.product_id, COUNT(o.product_id) AS available_orders FROM products p LEFT JOIN order_info o ON  p.product_id = o.product_id GROUP BY p.product_id) o ON p.product_id = o.product_id";
        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setDescription(resultSet.getString("product_description"));
                product.setStock(resultSet.getInt("available_stock"));
                product.setOrders(resultSet.getInt("available_orders"));
                productsList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productsList;
    }
   

        @FXML
        private TableView<Products> table;

        @FXML
        private TableColumn<Products, Integer> idColumn;

        @FXML
        private TableColumn<Products, String> nameColumn;

        @FXML
        private TableColumn<Products, Double> priceColumn;

        @FXML
        private TableColumn<Products, String> descColumn;

        @FXML
        private TableColumn<Products, Integer> stockColumn;

        @FXML
        private TableColumn<Products, Integer> ordersColumn;


        public void initialize() {

            List<Products> productList = getAllProducts();

            idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
            nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
            priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
            descColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
            stockColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStock()).asObject());
            ordersColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOrders()).asObject());

            table.getItems().addAll(productList);
        }

}