package utils;

import java.util.HashMap;
import java.util.Map;

import customException.VehicleException;
import vehicle.Vehicle;
import static utils.ValidationRules.validateAllInputs;

public class PopulateDetails {

	public static Map<String, Vehicle> populateMap() throws VehicleException {
		Map<String, Vehicle> vehiMap = new HashMap<>();

		System.out.println(vehiMap.put("abc-1234",
				ValidationRules.validateAllInputs("abc-1234", "red", 345678, "2023-02-14", "Honda", vehiMap)));
		System.out.println(vehiMap.put("abc-1230",
				ValidationRules.validateAllInputs("abc-1230", "white", 445678, "2023-03-14", "Honda", vehiMap)));
		System.out.println(vehiMap.put("abc-1238",
				ValidationRules.validateAllInputs("abc-1238", "red", 315678, "2023-03-01", "Maruti", vehiMap)));
		return vehiMap;
	}

}
