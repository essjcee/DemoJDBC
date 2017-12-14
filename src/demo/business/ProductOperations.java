package demo.business;

import java.util.List;

import demo.data.DataAccess;
import demo.data.DataAccessOracle;
import demo.data.ProductDAL;

public class ProductOperations {
	
	//Test Operations Like Sort etc against test data
	public List<Product> allProducts(){
		ProductDAL dao = new DataAccessOracle();
		List<Product> products = dao.getAllProducts();
		return products;
	}
}
