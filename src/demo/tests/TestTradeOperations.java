package demo.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import demo.business.Trade;
import demo.business.TradeOperations;
import static org.hamcrest.CoreMatchers.*;

public class TestTradeOperations {

	@Test
	public void testTopFiveTrades() {
		TradeOperations trops = new TradeOperations();
		List<Trade> actual = trops.topFiveTrades();
		List<Trade> expected = Arrays.asList(
				new Trade("BBBB",9,15.7),
				new Trade("EEEE",14,18.5),
				new Trade("KKKK",12,16.1),
				new Trade("AAAA",11,15),
				new Trade("HHHH",9,12.51)
				);
		for(int i = 0;i<actual.size();i++){
			assertEquals(actual.get(i).getTicker(),expected.get(i).getTicker());
			assertEquals(actual.get(i).getDailychange(),expected.get(i).getDailychange(),0.00001);
		}
		assertTrue(expected.equals(actual));
			
	}

}
