package demo.data;

import java.util.List;

public class TestOracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> products = DataAccess.getProducts();
		for(String product:products){
			System.out.println(product);
		}
	}

}
