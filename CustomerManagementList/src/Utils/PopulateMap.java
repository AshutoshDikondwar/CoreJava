package utils;

import java.util.HashMap;
import java.util.Map;

import customer.Customer;
import exceptionHandling.CustomerException;

public class PopulateMap {
	public static Map<String, Customer> populateMapDetails() throws CustomerException {
		Map<String, Customer> custMap = new HashMap<>();

		System.out.println("put " + custMap.put("ashu@gmail.com", ValidationRules.validateAllInputs("Ashutosh",
				"Dikondwar", "ashu@gmail.com", "ashu123", 1000, "2000-03-02", "gold", custMap)));
		
		System.out.println(custMap.put("john@gmail.com", ValidationRules.validateAllInputs("John", "Doe",
				"john@gmail.com", "john123", 500, "1985-05-12", "silver", custMap)));

		System.out.println(custMap.put("jane@gmail.com", ValidationRules.validateAllInputs("Jane", "Smith",
				"jane@gmail.com", "jane123", 2000, "1990-12-23", "diamond", custMap)));

		System.out.println(custMap.put("bob@gmail.com", ValidationRules.validateAllInputs("Bob", "Johnson",
				"bob@gmail.com", "bob123", 1000, "1982-08-16", "gold", custMap)));

		System.out.println(custMap.put("sara@gmail.com", ValidationRules.validateAllInputs("Sara", "Lee",
				"sara@gmail.com", "sara123", 500, "1995-02-08", "silver", custMap)));

		System.out.println(custMap.put("mark@gmail.com", ValidationRules.validateAllInputs("Mark", "Davis",
				"mark@gmail.com", "mark123", 2000, "1988-11-05", "diamond", custMap)));

		System.out.println(custMap.put("amy@gmail.com", ValidationRules.validateAllInputs("Amy", "Johnson",
				"amy@gmail.com", "amy123", 1000, "1980-04-18", "gold", custMap)));

		System.out.println(custMap.put("peter@gmail.com", ValidationRules.validateAllInputs("Peter", "Kim",
				"peter@gmail.com", "peter123", 500, "1992-09-27", "silver", custMap)));

		System.out.println(custMap.put("linda@gmail.com", ValidationRules.validateAllInputs("Linda", "Smith",
				"linda@gmail.com", "linda123", 2000, "1978-06-30", "diamond", custMap)));

		System.out.println(custMap.put("david@gmail.com", ValidationRules.validateAllInputs("David", "Brown",
				"david@gmail.com", "david123", 1000, "1987-03-15", "gold", custMap)));

		return custMap;

	}

}
