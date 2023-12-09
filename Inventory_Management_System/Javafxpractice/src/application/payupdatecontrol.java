package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;    
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class payupdatecontrol {
	@FXML
    private TextField payid;

	public void updatepaystatus() {
        database db = new database();

        try (Connection connection = db.getConnection()) {
            String updateQuery = "UPDATE payment SET payment_status='Yes' WHERE payment_id=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, Integer.parseInt(payid.getText()));
                int rowsAffected = preparedStatement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);
                showAlert(AlertType.INFORMATION, "Completed",rowsAffected + "rows updated successfully.");
            }
        } catch (SQLException e) {
        	showAlert(AlertType.ERROR,"Error","Cannot Complete your request");
            e.printStackTrace();
        }
    }

	
	public void updatepay(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.updatepay();
	}
	
	public void navigatepay(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.payment();
	}
	
	private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
