package application;

import javafx.scene.input.MouseEvent;
import javafx.beans.property.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class supplycontrol {
	public void navigateback(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.Homepage();
	}
	
	public void updatesupply(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.Homepage();
	}
	
	public void navigatesupply(MouseEvent event) {
		pagenavigator nav= new pagenavigator();
		nav.supplypage();
	}

	database database = new database();


    @FXML
    private TableView<Supplier> supplyTable;

    @FXML
    private TableColumn<Supplier, Integer> SID;

    @FXML
    private TableColumn<Supplier, String> SNME;

    @FXML
    private TableColumn<Supplier, String> SEMAIL;

    @FXML
    private TableColumn<Supplier, String> SLOCATION;

    @FXML
    private TableColumn<Supplier, Long> SMOBILE;

    // You can add other FXML elements and methods as needed

    @FXML
    void navigateBack(MouseEvent event) {
        // Implement navigation logic if needed
    }

    @FXML
    void initialize() {
        // Call this method in your controller to initialize the table
        initializeTable();
    }

    private void initializeTable() {
        SID.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSupplierId()).asObject());
        SNME.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierName()));
        SEMAIL.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        SLOCATION.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocation()));
        SMOBILE.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getMobile()).asObject());
        
        List<Supplier> supplierList = getAllSuppliers();

        supplyTable.setItems(FXCollections.observableArrayList(supplierList));
    }

    private List<Supplier> getAllSuppliers() {
        List<Supplier> supplierList = new ArrayList<>();
        database db=new database();
       
        try (Connection connection = db.getConnection()) {
            String selectQuery = "SELECT supplier_id,supplier_name,supplier_email,supplier_location,supplier_mobile FROM supplier";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int supplierId = resultSet.getInt("supplier_id");
                        String supplierName = resultSet.getString("supplier_name");
                        String email = resultSet.getString("supplier_email");
                        String location = resultSet.getString("supplier_location");
                        Long mobile = resultSet.getLong("supplier_mobile");

                        Supplier supplier = new Supplier(supplierId, supplierName, email, location, mobile);
                        supplierList.add(supplier);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return supplierList;
    }

}

