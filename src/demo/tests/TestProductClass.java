package demo.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import demo.business.Product;

public class TestProductClass {

	@Test
	public void testToString() {
		Product p = new Product(1, "Toshiba",  "Satellite Pro Laptop", 1000);
		assertTrue(p.toString().equals("Toshiba Satellite Pro Laptop(1) costs 1000.00"));
		//assertEquals
	}

}
