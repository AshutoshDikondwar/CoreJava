package vehicle;

import java.time.LocalDate;

public class Vehicle {
	private String chasisNo;
	private Colors vehicleColor;
	private double netPrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean isAvailable;

	public Vehicle(String chasisNo, Colors vehicleColor, double netPrice, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.netPrice = netPrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
	}

	public Colors getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(Colors vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", netPrice=" + netPrice
				+ ", manufactureDate=" + manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}

}
