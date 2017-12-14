package demo.data;

import java.util.Arrays;
import java.util.List;

import demo.business.Trade;

public class DataAccessForTesting implements TradeData{
	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		List<Trade> trades = Arrays.asList(new Trade("AAAA",11,15),
				new Trade("BBBB",9,15.7),//6.7
				new Trade("CCCC",12,15),//3
				new Trade("DDDD",17,19),//2
				new Trade("EEEE",14,18.5),//4.5
				new Trade("FFFF",10,11.27),//1.27
				new Trade("GGGG",5,8.5),//3.5
				new Trade("HHHH",9,12.51),//3.51
				new Trade("IIII",14,15.12),//1.12
				new Trade("JJJJ",8,6),//-2
				new Trade("KKKK",12,16.1)//4
				);
		return trades;
	}

}
	
