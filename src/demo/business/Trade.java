package demo.business;

public class Trade implements Comparable<Trade>{
	private String ticker;
	private double open;
	private double close;
	private double dailychange;
	public double getDailychange() {
		return dailychange;
	}
	public void setDailychange(double dailychange) {
		this.dailychange = dailychange;
	}
	public Trade(String ticker, double open, double close) {
		super();
		this.ticker = ticker;
		this.open = open;
		this.close = close;
		dailychange = close - open;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	@Override
	public int compareTo(Trade other) {
		// TODO Auto-generated method stub
		if(this.dailychange > other.dailychange){
			return 1;
		}
		else if(this.dailychange == other.dailychange){
			return 0;
		}
		else{
			return -1;
		}
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		if(!(o instanceof Trade)) return false;
		Trade t = (Trade)o;
		return t.getTicker().equals(ticker) &&
				t.getDailychange() == dailychange;
	}
	
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ticker.hashCode();
        result = 31 * result + (int)open;
        result = 31 * result + (int)close;
        result = 31 * result + (int)dailychange;
        return result;
    }
}
