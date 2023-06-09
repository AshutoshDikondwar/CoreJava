package customer;

public enum ServicePlan {
	GOLD(1000), SILVER(500), DIAMOND(2000);

	private double price;

	private ServicePlan(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name() ;
	}
}
