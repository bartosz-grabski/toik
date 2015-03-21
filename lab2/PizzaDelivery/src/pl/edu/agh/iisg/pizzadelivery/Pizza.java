package pl.edu.agh.iisg.pizzadelivery;

public class Pizza {

	private final String name;

	private final int price;

	public Pizza(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		return name + ": " + price;
	}

}
