package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;

import CustomerException.CustomerException;
import customer.Customer;
import customer.ServicePlan;

public class ValidationRules {

	public static Customer validateAllInputs(String name, String lastName, String email, String password, String dob,
			String plan, List<Customer> customer) throws CustomerException {
		checkForDuplicate(email, customer);
		LocalDate validateDob = parseAndValidateDate(dob);
		ServicePlan validatePlan = parseAndValidatePlan(plan);
		double netPrice = validatePlan.getPrice();
		return new Customer(name, lastName, email, password, netPrice, validateDob, validatePlan);

	}

	public static void checkForDuplicate(String email, List<Customer> customerList) throws CustomerException {

		Customer cust = new Customer(email);
		if (customerList.contains(cust))
			throw new CustomerException("same Person");
		System.out.println("You are Logged in");

	}

	public static LocalDate parseAndValidateDate(String date) throws CustomerException, DateTimeParseException {
		LocalDate dob = LocalDate.parse(date);
		int age = Period.between(dob, LocalDate.now()).getYears();

		if (age < 21)
			throw new CustomerException("You are not eligible for subscription");
		return dob;

	}

	public static int validateEmail(String email, List<Customer> customerList) throws CustomerException {
		Customer cust = new Customer(email);
		int index = customerList.indexOf(cust);
		if (index < 0)
			throw new CustomerException("Invalid Email id");
		return index;
	}

	public static int validateEmailAndPass(String email, String password, List<Customer> customerList)
			throws CustomerException {
		Customer cust = new Customer(email);
		int index = customerList.indexOf(cust);
		if (index < 0)
			throw new CustomerException("Invalid Email id");
		if (!(customerList.get(index).getPassword()).equals(password))
			throw new CustomerException("Invali Credentials");
		return index;
	}

	public static ServicePlan parseAndValidatePlan(String plan) {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

}
