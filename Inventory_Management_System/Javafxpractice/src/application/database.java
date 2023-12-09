package application;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;	
public class database {
	public Connection DatabaseLink;
		String databasename="inventory_management_system";
		String user="root";
		String password="root@MK";
		String url="jdbc:mysql://localhost:3306/"+databasename;
	
	public Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DatabaseLink=DriverManager.getConnection(url,user,password);
			return DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
    public void closeConnection() {
        try {
            if (DatabaseLink != null && !DatabaseLink.isClosed()) {
                DatabaseLink.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement preparedStatement = DatabaseLink.prepareStatement(query);

           
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insertData(int ProductID,String ProductName,String ProductDesc,double ProductPrice,String ProductBrand) {
        String insertQuery = "INSERT INTO Products () VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url,user,password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, ProductID);
            preparedStatement.setString(2, ProductName);
            preparedStatement.setString(3, ProductDesc);
            preparedStatement.setDouble(4, ProductPrice);
            preparedStatement.setString(5, ProductBrand);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
   
    public int deleteData(int ProductID) {
        String deleteQuery = "DELETE FROM Products WHERE product_id = ?";

        try (Connection connection = DriverManager.getConnection(url,user,password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, ProductID);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " row(s) deleted successfully.");
                return 1;
            } else {
                System.out.println("No rows deleted. User with ID " + ProductID + " not found.");
                return 0;
            }

        } catch (SQLException e) {
        	
            e.printStackTrace(); 
            System.out.println("Not connected");
            return 0;
        }
    }

    public int updateData(int ProductID,String ProductName,String ProductDesc,double ProductPrice,String ProductBrand) {
        String updateQuery = "UPDATE products SET product_name=?,product_description=?,product_price=?,product_brand=? WHERE product_id=?";

        try (Connection connection = DriverManager.getConnection(url,user,password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            
            preparedStatement.setString(1, ProductName);
            preparedStatement.setString(2, ProductDesc);
            preparedStatement.setDouble(3, ProductPrice);
            preparedStatement.setString(4, ProductBrand);
            preparedStatement.setInt(5, ProductID);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated successfully.");
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}