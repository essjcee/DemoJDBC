package demo.data;
import java.util.List;
import demo.business.*;

public interface ProductDAL {
	public List<Product> getAllProducts();
	public Product getProductByID(Product p);
	public Product getProductByMakeAndModel(String make, String description);
	public int addProduct(Product p);
	public int updateProduct(Product p);
	public int deleteProduct(Product p);
	public List<Product> getProductsByMake(String make);
}
