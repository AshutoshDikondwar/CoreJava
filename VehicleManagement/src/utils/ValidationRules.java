package utils;

import java.time.LocalDate;
import java.util.Map;

import customException.VehicleException;
import vehicle.Colors;
import vehicle.Vehicle;

public class ValidationRules {

//	VALIDATE VEHICLE ALL INPUTS
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double netPrice,
			String manufactureDate, String company, Map<String, Vehicle> vehicle) throws VehicleException {
		checkForDuplicate(chasisNo, vehicle);
		Colors vehiColor = parseAndValidateColors(vehicleColor);
		LocalDate manuDate = parseAndValidateDate(manufactureDate);
		Double finalPrice = vehiColor.getPrice() + netPrice;
		return new Vehicle(chasisNo, vehiColor, finalPrice, manuDate, company);

	}

//	CHECK FOR DUPLICATE VEHICLE
	public static void checkForDuplicate(String id, Map<String, Vehicle> vehicle) throws VehicleException {
		if (vehicle.containsKey(id))
			throw new VehicleException("Vehicle already present");
	}

//	VALIDATE CHASSIS NUMBER
	public static String validateKey(String chassisNo, Map<String, Vehicle> vehicle) throws VehicleException {

		for (Map.Entry<String, Vehicle> entry : vehicle.entrySet())
			if (entry.getKey().equals(chassisNo))
				return entry.getKey();
		throw new VehicleException("Enter valid Chassis number");

	}

// 	PARSE AND VALIDATE MANUFACTURING DATE
	public static LocalDate parseAndValidateDate(String date) throws VehicleException {
		LocalDate manufDate = LocalDate.parse(date);
		LocalDate beginYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		if (manufDate.isAfter(beginYear))
			return manufDate;
		throw new VehicleException("Vehicle manufacture date must be after 1st Jan of the curnt year");
	}

//	PARSE AND VALIDATE COLOR
	public static Colors parseAndValidateColors(String color) {
		return Colors.valueOf(color.toUpperCase());
	}

}
