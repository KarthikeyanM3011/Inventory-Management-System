package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class stkupdate {
	
	public void navigateBack(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.Homepage(); 
}
	
	public void navigatestock(MouseEvent event) {
    	pagenavigator nav=new pagenavigator();
    	nav.stockpage();  
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

	                
	                preparedStatement.setInt(1, Integer.parseInt(pquantity.getText()));
	                preparedStatement.setInt(2, Integer.parseInt(pid.getText()));

	                int rowsAffected = preparedStatement.executeUpdate();
	                System.out.println(rowsAffected + " row(s) updated successfully.");
	                showAlert(AlertType.INFORMATION, "Updated", "Successfully updated");
	                
	                
	        }
	        	catch(Exception e) {
	        		e.printStackTrace();
	        		showAlert(AlertType.ERROR, "ERROR", "Unable to complete your request.Try Again!.");
	        	}
	         
	    }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void showAlert(AlertType alertType, String title, String content) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }
}


