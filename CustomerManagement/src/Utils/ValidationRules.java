package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Map;

import customer.Customer;
import customer.ServicePlan;
import exceptionHandling.CustomerException;

public class ValidationRules {
//	String name, String lastName, String email, String password, double regAmount, LocalDate dob,
//	ServicePlan plan

//	VALIDATE ALL INPUTS
	public static Customer validateAllInputs(String name, String lastName, String email, String password,
			double regAmount, String dob, String plan, Map<String, Customer> custMap) throws CustomerException {
		checkForDuplicate(email, custMap);
		LocalDate dateOfBirt = parseAndValidateDate(dob);
		ServicePlan subscribedPlan = parseAndValidatePlan(plan);
		double fairPrice = validateRegAmount(regAmount, subscribedPlan);
		return new Customer(name, lastName, email, password, fairPrice, dateOfBirt, subscribedPlan);
	}

//	VALIDATE EMAIL FOR SIGN IN
	public static String validateEmail(String email, Map<String, Customer> custMap) throws CustomerException {
		for (Map.Entry<String, Customer> entry : custMap.entrySet())
			if (entry.getKey().equals(email))
				return entry.getKey();
		throw new CustomerException("Enter valid Email");

	}

//	REMOVE BY EMAIL
	public static void removeByEmail(String email, Map<String, Customer> custMap) throws CustomerException {
		validateEmail(email, custMap);
		custMap.entrySet().removeIf(entry -> entry.getKey().equals(email));

	}

//	VALIDATE EMAIL AND PASSWORD
	public static String validateEmailAndPass(String email, String pass, Map<String, Customer> custMap)
			throws CustomerException {
		for (Map.Entry<String, Customer> entry : custMap.entrySet())
//			if (entry.getKey().equals(email) && entry.getValue().getPassword().equals(pass))));
			if (entry.getKey().equals(email) && entry.getValue().getPassword().equals(pass))
				return entry.getKey();
		throw new CustomerException("Enter Valid Credentials");
	}

//	UNSUBSCIBE THE PLAN
	public static void unSubscibe(String email, Map<String, Customer> custMap) throws CustomerException {
		validateEmail(email, custMap);
		for (Map.Entry<String, Customer> entry : custMap.entrySet()) {
			if (entry.getKey().equals(email))
				if (entry.getValue().getPlan() != null) {
					entry.getValue().setPlan(null);
					entry.getValue().setRegAmount(0);
					System.out.println("Unsubscribed");
				} else {
					throw new CustomerException("You do not have any plan");
				}
		}
	}

//	CHANGE PLAN
	public static void changePlan(String email, String plan, Map<String, Customer> custMap) throws CustomerException {
		String key = validateEmail(email, custMap);
		ServicePlan changedPlan = parseAndValidatePlan(plan);
		for (ServicePlan s : ServicePlan.values())
			if (s == changedPlan) {
				custMap.get(key).setPlan(changedPlan);
				custMap.get(key).setRegAmount(changedPlan.getPrice());
			}

	}

//	CHECK DUPLICATE
	public static void checkForDuplicate(String email, Map<String, Customer> custMap) throws CustomerException {
		if (custMap.containsKey(email))
			throw new CustomerException("Email already exists");
	}

//	VALIDATE AMOUNT ENTERED
	public static double validateRegAmount(double amt, ServicePlan subscribedPlan) throws CustomerException {
		if (subscribedPlan.getPrice() == amt)
			return amt;
		throw new CustomerException("Enter Valid Amount ");
	}

//	PARSE AND VALIDATE SERVICEPLAN
	public static ServicePlan parseAndValidatePlan(String plan) {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

//	PARSE AND VALIDATE DOB
	public static LocalDate parseAndValidateDate(String date) throws CustomerException, DateTimeParseException {
		int age = Period.between(LocalDate.parse(date), LocalDate.now()).getYears();
		if (age < 21)
			throw new CustomerException("You are not Eligible for the Subscription");
		return LocalDate.parse(date);
	}
}
