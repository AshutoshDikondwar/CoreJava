package vehicle;

public enum Colors {
	BLACK(5000), WHITE(3000), RED(2000), YELLOW(1000);

	private double price;

	private Colors(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return name() + " @ " + price;
	}

}
