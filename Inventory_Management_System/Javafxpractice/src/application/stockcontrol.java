 package application;

import javafx.scene.input.MouseEvent; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class stockcontrol{
	

    @FXML
    private TableView<stocks> stockTable;

    @FXML
    private TableColumn<stocks, Integer> productIdColumn;

    @FXML
    private TableColumn<stocks, Integer> availableStockColumn;

    @FXML
    private TableColumn<stocks, String> productNameColumn;  
    
    @FXML
    public void navigateBack(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.stockpage();  
}
    
    public void navigateupdate(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.Homepage();  
    }
    
    public List<stocks> getAllStocks() {
        List<stocks> stockList = new ArrayList<>();

        database db = new database();
        try (Connection connection = db.getConnection()) {
            String selectQuery = "SELECT * FROM stocks";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int productId = resultSet.getInt("product_id");
                        int availableStock = resultSet.getInt("available_stock");
                        String productName = resultSet.getString("product_name");
                        System.out.println(productId);

                        stocks stock = new stocks(productId, availableStock, productName);
                        stockList.add(stock);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stockList;
    }
    
    @FXML
    public void initialize() {
    	
    	List<stocks> stockList = getAllStocks();
   	
        productIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProductId()).asObject());
        availableStockColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAvailableStock()).asObject());
        productNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));

        stockTable.getItems().addAll(stockList);
    }
}
