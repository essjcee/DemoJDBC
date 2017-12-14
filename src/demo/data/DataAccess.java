package demo.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
	public static List<String> getProducts(){
		List<String> products = new ArrayList<String>();
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
		}
		catch(SQLException ex){ // ClassNotFoundException for Class.forName
			System.out.println(ex.getMessage());
		}
		try{
			Connection cn = null;
			ResultSet rs = null;
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"Northwind","Pa$$w0rd");
			Statement st = cn.createStatement();
            rs = st.executeQuery("SELECT ProductName, UnitPrice FROM Products");
            // Process the results of the query, one row at a time
            while (rs.next()) { 
                String name = rs.getString("ProductName");
                double price = rs.getDouble("UnitPrice");
                products.add("Name: " + name + " Price: " + price);
            }
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return products;
	}
}
