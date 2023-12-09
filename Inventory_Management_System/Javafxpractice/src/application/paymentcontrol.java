package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class paymentcontrol {
	public void navigateback(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.Homepage();
	}
	
	public void updatepay(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.updatepay();
	}
	
	public void navigatepay(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.payment();
	}
	
	private List<PaymentData> getPaymentDataFromDatabase() {
        List<PaymentData> paymentDataList = new ArrayList<>();
        	
        database db = new database();

        try (Connection connection = db.getConnection()) {
            String selectQuery = "SELECT p.payment_id, p.order_id, oi.order_TotalPrice, oi.order_quantity FROM payment p JOIN order_info oi ON p.order_id = oi.order_id WHERE p.payment_status = 'No'";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int paymentId = resultSet.getInt("payment_id");
                        int orderId = resultSet.getInt("order_id");
                        double orderTotalPrice = resultSet.getDouble("order_TotalPrice");
                        int orderQuantity = resultSet.getInt("order_quantity");

                        PaymentData paymentData = new PaymentData(paymentId, orderId, orderTotalPrice, orderQuantity);
                        paymentDataList.add(paymentData);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paymentDataList;
    }
	
	@FXML
    private TableView<PaymentData> payTable;

    @FXML
    private TableColumn<PaymentData, Integer> paymentIdColumn;

    @FXML
    private TableColumn<PaymentData, Integer> orderIdColumn;

    @FXML
    private TableColumn<PaymentData, Double> orderTotalPriceColumn;

    @FXML
    private TableColumn<PaymentData, Integer> orderQuantityColumn;
    
    
    public void initialize() {
//    	payTable.getItems().clear();
    	
        List<PaymentData> paymentDataList = getPaymentDataFromDatabase();

        
        paymentIdColumn.setCellValueFactory(cellData -> cellData.getValue().paymentIdProperty().asObject());
        orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
        orderTotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().orderTotalPriceProperty().asObject());
        orderQuantityColumn.setCellValueFactory(cellData -> cellData.getValue().orderQuantityProperty().asObject());

        payTable.getItems().addAll(paymentDataList);
    }
    
    }
