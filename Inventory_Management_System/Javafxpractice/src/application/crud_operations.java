package application;

import javafx.fxml.FXML;   
import javafx.scene.control.Alert;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;



public class crud_operations extends database {
	@FXML
    private TextField ProductBrand;

    @FXML
    private TextField ProductDesc;

    @FXML
    private TextField ProductID;
    
    @FXML
    private TextField id;

    @FXML
    private TextField ProductName;

    @FXML
    private TextField ProductPrice;
    
    @FXML
    private TextField PBrand;

    @FXML
    private TextField PID;

    @FXML
    private TextField PName;

    @FXML
    private TextField PP;
    
    @FXML
    private TextField PDesc;
    
    pagenavigator nav= new pagenavigator();

    @FXML
	public void addproduct(MouseEvent event) {
    	
		int x=(int) insertData(
				Integer.parseInt(ProductID.getText()),
				ProductName.getText(),
				ProductDesc.getText(),
				Double.parseDouble(ProductPrice.getText()),
				ProductBrand.getText()
				);
		if(x==0) {
			showAlert(AlertType.ERROR, "Insert Error", "Unable to insert to the database.");
		}
		else {
			showAlert(AlertType.INFORMATION, "Added", "Added Successfully successfully");
		}
		
	}
    @FXML
    public void delproduct(MouseEvent event) {
    	
		int x=(int) deleteData(
				Integer.parseInt(id.getText())
				);
		if(x==0) {
			showAlert(AlertType.ERROR, "Remove Error", "Unable to remove from the database.");
		}
		else {
			showAlert(AlertType.INFORMATION, "Deleted", "Deleted successfully");
		}

		
	}
    
    @FXML
    public void updateproduct(MouseEvent event) {
    	
		int x=(int) updateData(
				Integer.parseInt(PID.getText()),
				PName.getText(),
				PDesc.getText(),
				Double.parseDouble(PP.getText()),
				PBrand.getText()
				);
		if(x==0) {
			showAlert(AlertType.ERROR, "update Error", "Unable to update to the database.");
		}
		else {
			showAlert(AlertType.INFORMATION, "Updated", "Updated successfully");
		}

	}
	 
    @FXML
    public void navigateBack(MouseEvent event) {
//    	Main.cstage.setScene(Main.homescene);
    	nav.manageproduct();
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();  
}
}
