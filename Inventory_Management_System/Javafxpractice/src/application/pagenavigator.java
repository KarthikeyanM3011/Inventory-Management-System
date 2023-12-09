package application;

import javafx.fxml.FXMLLoader;  
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Stack;

public class pagenavigator {
	 private Stack<Scene> pageHistory = new Stack<>();
	 public void Homepage() {
	        try {
	        	Main.cstage.setScene(Main.homescene);
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 public void manageproduct() {
	        try {   	
	        	 Scene manageprodscene;
		         FXMLLoader manageprodloader = new FXMLLoader(getClass().getResource("manageproducts.fxml"));
		   	     Parent manageprodroot = manageprodloader.load();
		   	     manageprodscene = new Scene(manageprodroot);
	        	Main.cstage.setScene(manageprodscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	 }
	 
	 public void updateorder() {
	        try {   	
	        	 Scene updateorderscene;
		         FXMLLoader updateorderloader = new FXMLLoader(getClass().getResource("updateorders.fxml"));
		   	     Parent updateorderroot = updateorderloader.load();
		   	  updateorderscene = new Scene(updateorderroot);
	        	Main.cstage.setScene(updateorderscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	 }
	 
	 public static void updatestock() {
	        try {   	
	        	System.out.println("Update stock");
	      	   Main.cstage.setScene(Main.ustockscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	 }
	 	
	 public void orders() {
	        try {   	
	        	
//	        	Main.cstage.setScene(Main.orderscene);
	        	Scene orderscene;
	        	FXMLLoader orderloader = new FXMLLoader(getClass().getResource("orders.fxml"));
	   	     	Parent orderroot = orderloader.load();
	   	     	orderscene=new Scene(orderroot);
	   	     	Main.cstage.setScene(Main.orderscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	 }

	 
	 
	 public void Addproduct() {
	        try {   	
	        	Main.pscene=Main.cstage.getScene();
	        	Main.cstage.setScene(Main.addscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	 }
	 
	 public void updatepay() {
	        try {   	
	        	Scene uppayscene;
	        	FXMLLoader orderloader = new FXMLLoader(getClass().getResource("paymentupdate.fxml"));
	   	     	Parent uppayroot = orderloader.load();
	   	     	uppayscene=new Scene(uppayroot);
	   	     	Main.cstage.setScene(uppayscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	 }
	 
	 public void payment() {
	        try {   	
	        	Scene payscene;
	        	FXMLLoader orderloader = new FXMLLoader(getClass().getResource("payment.fxml"));
	   	     	Parent payroot = orderloader.load();
	   	     	payscene=new Scene(payroot);
	   	     	Main.cstage.setScene(payscene);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	 }
	 
	 public void stockpage() {
		 try {
			 Scene stockscene;
	        	FXMLLoader orderloader = new FXMLLoader(getClass().getResource("stockpage.fxml"));
	   	     	Parent stockroot = orderloader.load();
	   	     stockscene=new Scene(stockroot);
	   	     	Main.cstage.setScene(stockscene);
		 }
		 catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void supplypage() {
		 try {
			 Main.pscene=Main.cstage.getScene();
	        	Main.cstage.setScene(Main.supplyscene);
		 }
		 catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 
	 public void Removeproduct() {
	        try {
	        	Main.pscene=Main.cstage.getScene();
	        	Main.cstage.setScene(Main.deletescene); 

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
    public void Updateproduct() {
        try {
        	Main.pscene=Main.cstage.getScene();
        	Main.cstage.setScene(Main.updatescene);

        } catch (Exception e) {
            e.printStackTrace();
        }

	 }
    
    public void navigateBack() {
            Main.cstage.setScene(Main.pscene);
//            Homepagecontroller controller = new Homepagecontroller();
//        	controller.initialize();
        }
	  
}
