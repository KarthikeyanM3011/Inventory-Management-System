package application;
	
import javafx.application.Application;     
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Main extends Application {
	public static  Stage cstage;
	public static  Scene pscene;
	public static Scene loginscene;
	public static Scene homescene;
	public static Scene addscene;
	public static Scene updatescene;
	public static Scene deletescene;
	public static Scene managescene;
	public static Scene stockscene;
	public static Scene supplyscene;
	public static Scene orderscene;
	public static Scene paymentscene;
	public static Scene ustockscene;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		 cstage=primaryStage;
		 FXMLLoader loginloader = new FXMLLoader(getClass().getResource("javafxpractice.fxml"));
	     Parent loginroot = loginloader.load();
	     FXMLLoader homeloader = new FXMLLoader(getClass().getResource("homepage.fxml"));
	     Parent homeroot = homeloader.load();
	     FXMLLoader addloader = new FXMLLoader(getClass().getResource("addproduct.fxml"));
	     Parent addroot = addloader.load();
	     FXMLLoader updateloader = new FXMLLoader(getClass().getResource("updateproduct.fxml"));
	     Parent updateroot = updateloader.load();
	     FXMLLoader deleteloader = new FXMLLoader(getClass().getResource("deleteproduct.fxml"));
	     Parent deleteroot = deleteloader.load();
	     FXMLLoader manageloader = new FXMLLoader(getClass().getResource("manageproducts.fxml"));
	     Parent manageroot = manageloader.load();
	     FXMLLoader stockloader = new FXMLLoader(getClass().getResource("stockpage.fxml"));
	     Parent stockroot = stockloader.load();
	     FXMLLoader supplyloader = new FXMLLoader(getClass().getResource("supplypage.fxml"));
	     Parent supplyroot = supplyloader.load();
	     FXMLLoader paymentloader = new FXMLLoader(getClass().getResource("supplypage.fxml"));
	     Parent paymentroot = paymentloader.load();
	     FXMLLoader orderloader = new FXMLLoader(getClass().getResource("orders.fxml"));
	     Parent orderroot = orderloader.load();
	     FXMLLoader ustockloader = new FXMLLoader(getClass().getResource("stockupdate.fxml"));
  	     Parent ustockroot = ustockloader.load();
	    

	     
	     loginscene = new Scene(loginroot);
	     homescene = new Scene(homeroot);
	     addscene = new Scene(addroot);
	     updatescene = new Scene(updateroot);
	     deletescene = new Scene(deleteroot);
	     managescene = new Scene(manageroot);
	     stockscene = new Scene(stockroot);
	     supplyscene = new Scene(supplyroot);
	     paymentscene = new Scene(paymentroot);
	     orderscene=new Scene(orderroot);
	     ustockscene = new Scene(ustockroot);
	     
	     
	     cstage.setTitle("Inventory Management System");
	     cstage.setScene(loginscene);
	     cstage.show(); 
	     
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
