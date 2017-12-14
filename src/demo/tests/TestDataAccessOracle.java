package demo.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import demo.business.*;
import demo.data.*;

public class TestDataAccessOracle {

	@Test
	public void testGetAllProducts() {
		ProductDAL dac = new DataAccessOracle();
		TradeData trops = new DataAccessOracle();
		List<Product> products = dac.getAllProducts();
		Product p = products.get(0);
		assertTrue(products.size() > 0);
		assertTrue(p.getId()>0);
		List<Trade> trades = trops.getAllTrades();
		assertTrue(trades.size() > 0);
		Trade atrade = trades.get(0);
		assertTrue(atrade.getTicker().equals("AACC"));
	}
	
	/*@Test
	public void testInsert(){
		ProductDAL dac = new DataAccessOracle();
		Product p = new Product(-1, "Toshiba", "External USB Drive 5TB", 600);
		assertEquals(1,dac.addProduct(p));
	}*/
	
	@Test
	public void testGetProductByMakeModel(){
		ProductDAL dac = new DataAccessOracle();
		Product p = dac.getProductByMakeAndModel("Apple", "Ipad Mini");
		assertEquals("Apple",p.getMake());
	}

}
