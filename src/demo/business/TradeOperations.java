package demo.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import demo.data.*;
import demo.data.TradeData;

public class TradeOperations {
	public List<Trade> topFiveTrades(){
		List<Trade> topfive = new ArrayList<Trade>();
		TradeData trds = new DataAccessForTesting();
		List<Trade> trades = trds.getAllTrades();
		Collections.sort(trades,Collections.reverseOrder());
		for(int i = 0;i < 5; i++){
			topfive.add(trades.get(i));
		}
		return topfive;
	}
}
