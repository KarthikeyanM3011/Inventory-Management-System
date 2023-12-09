package application;
  
import javafx.scene.control.Alert;    
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.sql.ResultSet; 
import javafx.scene.control.PasswordField;
import java.sql.SQLException;	
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class javafxpractice_controller extends pagenavigator{
		database Db = new database();


	   @FXML
	    private Button loginbutton;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private TextField username;

	    @FXML
	    void validate(MouseEvent event) {
	        String name = username.getText();
	        String pass = password.getText();
	        System.out.println(name);

	        database database = new database();

	        if (database.getConnection() != null) {
	            String selectQuery = "SELECT user_password FROM administration WHERE user_name = ?";
	            
	            try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(selectQuery)) {
	                preparedStatement.setString(1, name);

	                ResultSet resultSet = preparedStatement.executeQuery();

	                if (resultSet.next()) {
	                    String storedPassword = resultSet.getString("user_password");

	                    if (pass.equals(storedPassword)) {

	                        System.out.println("Login successful!");
	                        Homepage();
	                    } else {
	                    	showAlert(AlertType.ERROR, "Authentication Error", "Please Enter correct Password.");
	                        System.out.println("Incorrect password");
	                    }
	                } else {
	                	showAlert(AlertType.ERROR, "Authentication Error", "User not Found!");
	                    System.out.println("User not found");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	                database.closeConnection();
	            }
	        }
	        else {
	        	showAlert(AlertType.ERROR, "Database Connection Error", "Unable to connect to the database.");
	        	System.out.println("Not connected");
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


