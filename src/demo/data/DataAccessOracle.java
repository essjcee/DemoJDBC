package demo.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.business.Product;
import demo.business.Trade;
import oracle.jdbc.internal.OracleTypes;

public class DataAccessOracle implements ProductDAL,TradeData{

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection cn = null;
		ResultSet rs = null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");ClassNotFoundException for Class.forName
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"Northwind","Pa$$w0rd");
			Statement st = cn.createStatement();
            rs = st.executeQuery("SELECT Product_ID, Product_Description," +
            					"Product_Make, Product_Unit_Price FROM JCProducts");
            // Process the results of the query, one row at a time
            while (rs.next()) { 
                products.add(new Product(rs.getInt("Product_ID"),rs.getString("Product_Make")
                		,rs.getString("Product_Description"),rs.getDouble("Product_Unit_Price")));
            }
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(cn != null){
				try{
					if(!cn.isClosed()){
						cn.close();
					}
				}
				catch(SQLException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		return products;
	}

	@Override
	public Product getProductByID(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Product> getProductsByMake(String make) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		int rows = 0;
		Driver d = new oracle.jdbc.driver.OracleDriver();
		try {
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						"Northwind","Pa$$w0rd");) {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO JCProducts(Product_Description," +
						"Product_Make,Product_Unit_Price) VALUES(?,?,?)");
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getMake());
			ps.setDouble(3, p.getPrice());
			rows = ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return rows;
	}

	@Override
	public int updateProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getProductByMakeAndModel(String make, String description) {
		// TODO Auto-generated method stub
		Product product = null;
		Connection cn = null;
		ResultSet rs = null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");ClassNotFoundException for Class.forName
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"Northwind","Pa$$w0rd");
			CallableStatement st = cn.prepareCall("{call getProductByMakeDescription(?,?,?)}");
            st.setString(1, make);
            st.setString(2, description);
            st.registerOutParameter(3, OracleTypes.CURSOR);
            st.executeUpdate();
            rs = (ResultSet) st.getObject(3);
            // Process the results of the query, one row at a time
            if (rs.next()) { 
                product = new Product(rs.getInt("PRODUCT_ID"),rs.getString("PRODUCT_MAKE")
                		,rs.getString("PRODUCT_DESCRIPTION"),
                		rs.getDouble("PRODUCT_UNIT_PRICE"));
            }
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(cn != null){
				try{
					if(!cn.isClosed()){
						cn.close();
					}
				}
				catch(SQLException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		return product;
	}

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		List<Trade> trades = new ArrayList<Trade>();
		Driver d = new oracle.jdbc.driver.OracleDriver();
		try {
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						"Northwind","Pa$$w0rd");) {
			PreparedStatement ps = cn.prepareStatement("SELECT Ticker, Open, Close FROM NASDAQDATAJC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				trades.add(new Trade(rs.getString("Ticker"),rs.getDouble("Open"),rs.getDouble("Close")));
			}
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return trades;
	}

}
