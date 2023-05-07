package test;

import static utils.ValidationRules.parseAndValidateColors;
import static utils.ValidationRules.parseAndValidateDate;
import static utils.ValidationRules.validateAllInputs;
import static utils.ValidationRules.validateKey;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import customException.VehicleException;
import utils.PopulateDetails;
import vehicle.Colors;
import vehicle.Vehicle;

public class VehicleManagement {

	public static void main(String[] args) throws VehicleException {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Vehicle> vehiMap = PopulateDetails.populateMap();
			boolean exit = false;

			while (!exit) {
				System.out.println("Options 1. Add a Vehicle 2. Display all "
						+ "3. Get specific vehicle details 4. Apply discount  "
						+ "5. Delete vehicle details  by ch no 6. Delete vehicles by color "
						+ "7. Sort the vehicles as per ch no " + "8. Sort the vehicles as per price "
						+ "9. Sort the vehicles as per date n price " + "10. Sort the vehicles as per date 0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  netPrice,  manufactureDate(yr-mon-day),  company");
						Vehicle validVehicle = validateAllInputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next(), vehiMap);
						vehiMap.put(validVehicle.getChasisNo(), validVehicle);
						System.out.println("Vehicle Added Successfully");
						break;
					case 2:
						vehiMap.entrySet().forEach(entry -> System.out.println(entry));
						break;
					case 3:
						System.out.println("Enter chassis number");
						String key = validateKey(sc.next(), vehiMap);
						System.out.println(vehiMap.get(key));
						break;
					case 4:
						System.out.println("Enter date n discount amount");
						LocalDate date = parseAndValidateDate(sc.next());
						double discount = sc.nextDouble();
						for (Map.Entry<String, Vehicle> entry : vehiMap.entrySet())
							if (entry.getValue().getManufactureDate().isBefore(date))
								entry.getValue().setNetPrice(entry.getValue().getNetPrice() - discount);
						System.out.println("Discount applied Successfully");
						break;
					case 5:
						System.out.println("Enter chassis no");
						key = validateKey(sc.next(), vehiMap);
						vehiMap.entrySet().removeIf(entry -> entry.getKey().equals(key));
						System.out.println("Vehicle removed Successfully");
						break;
					case 6:
						System.out.println("Enter Color");
						Colors vehiColor = parseAndValidateColors(sc.next());
						boolean flag = vehiMap.entrySet()
								.removeIf(entry -> entry.getValue().getVehicleColor() == vehiColor);
						if (flag)
							System.out.println("Vehicle removed successfully");
						else
							System.out.println("NO vehicle for " + vehiColor + " color");
						break;
					case 7:
						Map<String, Vehicle> treemap = new TreeMap<>(vehiMap);
						treemap.entrySet().forEach(entry -> System.out.println(entry));
						break;
					case 8:
						List<Map.Entry<String, Vehicle>> sort = new ArrayList<>(vehiMap.entrySet());
						Collections.sort(sort, (entry1, entry2) -> Double.valueOf(entry1.getValue().getNetPrice())
								.compareTo(entry2.getValue().getNetPrice()));
						for (Map.Entry<String, Vehicle> entry : sort) {
							System.out.println(entry.getValue());
						}
						break;
					case 9:
						List<Map.Entry<String, Vehicle>> sortList = new ArrayList<>(vehiMap.entrySet());
						Collections.sort(sortList, (entry1, entry2) -> {
							LocalDate d1 = entry1.getValue().getManufactureDate();
							LocalDate d2 = entry2.getValue().getManufactureDate();
							int dateComp = d1.compareTo(d2);
							if (dateComp != 0) {
								return dateComp;
							}
							double price1 = entry1.getValue().getNetPrice();
							double price2 = entry2.getValue().getNetPrice();
							return Double.compare(price1, price2);
						});
						for (Map.Entry<String, Vehicle> entry : sortList) {
							System.out.println(entry.getValue());
						}
						break;
					case 10:
						List<Map.Entry<String, Vehicle>> sortListBYDate = new ArrayList<>(vehiMap.entrySet());
						Collections.sort(sortListBYDate, (entry1, entry2) -> {
							LocalDate date1 = entry1.getValue().getManufactureDate();
							LocalDate date2 = entry2.getValue().getManufactureDate();
							return date1.compareTo(date2);
						});
						for (Map.Entry<String, Vehicle> entry : sortListBYDate) {
							System.out.println(entry.getValue());
						}
						break;
					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

}
