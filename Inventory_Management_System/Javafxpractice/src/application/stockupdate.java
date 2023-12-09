package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class stockupdate {
	public void navigateBack(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.Homepage(); 
}
	
	public void navupdate(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.updatestock();
}
	
    
    public void navigatestock(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.stockpage();  
    }
	
    public void navigatehome(MouseEvent event) {
    	Main.cstage.setScene(Main.homescene);
}
    
    @FXML
    private TextField pid;

    @FXML
    private TextField pquantity;

    @FXML
    void updstock(MouseEvent event) {
    	database db=new database();
    	String updateQuery = "UPDATE stocks SET available_stock = available_stock + ? WHERE product_id = ?";

        try (Connection connection = db.getConnection()){
        	try(PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                
                preparedStatement.setInt(1, Integer.parseInt(pid.getText()));
                preparedStatement.setInt(2, Integer.parseInt(pquantity.getText()));

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated successfully.");
                
        }
        	catch(Exception e) {
        		e.printStackTrace();
        	}
         
    }
        catch (Exception e) {
            e.printStackTrace();
        }
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
	    private TableView<stocks> stockTable;

	    @FXML
	    private TableColumn<stocks, Integer> productIdColumn;

	    @FXML
	    private TableColumn<stocks, Integer> availableStockColumn;

	    @FXML
	    private TableColumn<stocks, String> productNameColumn;  
	    
	    @FXML
	    public void initialize() {
	    	
	    	List<stocks> stockList = getAllStocks();
	   	
	        productIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProductId()).asObject());
	        availableStockColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAvailableStock()).asObject());
	        productNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
	
	        stockTable.getItems().addAll(stockList);
	    }
	    
}
