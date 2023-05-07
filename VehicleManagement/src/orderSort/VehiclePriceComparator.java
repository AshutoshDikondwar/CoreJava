package orderSort;

import vehicle.Vehicle;

public class VehiclePriceComparator {
	public int compare(Vehicle v1, Vehicle v2) {
		System.out.println("in compare : price");
		if (v1.getNetPrice() < v2.getNetPrice())
			return -1;
		if (v1.getNetPrice() == v2.getNetPrice())
			return 0;
		return 1;
	}

}
