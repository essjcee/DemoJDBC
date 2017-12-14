package demo.ui;

import java.util.List;

import demo.business.Product;
import demo.business.*;


public class ConsoleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TradeOperations trops = new TradeOperations();
		List<Trade> bestfive = trops.topFiveTrades();
		for(Trade t:bestfive){
			System.out.println(String.format("%s %.2f", t.getTicker(),t.getDailychange()));
		}
	}
}
