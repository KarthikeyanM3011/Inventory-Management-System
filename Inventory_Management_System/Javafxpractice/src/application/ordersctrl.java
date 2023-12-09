package application;

import java.sql.PreparedStatement;
import javafx.scene.control.Alert;    
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ordersctrl {
	
	@FXML
    private TextField updateorderid;
	
	public void navigateorders(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.orders();
	}
	public void navigateupdate(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.updateorder();
	}
	
    public void updateorders(MouseEvent event) {
    	database database=new database();
        String updateQuery = "UPDATE order_info SET order_status = 'Yes' WHERE order_id = ?";
        
        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, Integer.parseInt(updateorderid.getText()));
            int result = preparedStatement.executeUpdate();
            
            System.out.println(result + " Rows affected");
            showAlert(AlertType.INFORMATION, "Completed"," updated successfully.");
        } catch (Exception e) {
        	showAlert(AlertType.ERROR,"Error","Cannot Complete your request");
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
