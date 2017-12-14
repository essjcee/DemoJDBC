package demo.business;

public class Product {
	private int id;
	private String make;
	private String description;
	private double price;
	
	public Product(int id, String make, String description, double price) {
		super();
		this.id = id;
		this.make = make;
		this.description = description;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString(){
		return String.format("%s %s(%d) costs %.2f",make,description,id,price);
	}
}
