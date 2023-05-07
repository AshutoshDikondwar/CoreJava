package test;

import static utils.PopulateMap.populateMapDetails;
import static utils.ValidationRules.changePlan;
import static utils.ValidationRules.removeByEmail;
import static utils.ValidationRules.unSubscibe;
import static utils.ValidationRules.validateAllInputs;
import static utils.ValidationRules.validateEmail;
import static utils.ValidationRules.validateEmailAndPass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import customer.Customer;
import customer.ServicePlan;
import exceptionHandling.CustomerException;

public class CustomerManagement {
	public static void main(String[] args) throws CustomerException {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Customer> custMap = populateMapDetails();

			boolean exit = false;

			while (!exit) {
				System.out.println(
						"1: Sign up, 2: Sign in, 3: Change password, 4: Display All Customers, 5: Search by email, 6: Remove by email, 7: Unsubscribe Customer, 8:Change plan, 9: Sort by email , 0: exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("name, lastName, email, password, regAmount, dob, plan");
						Customer validCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), custMap);
						custMap.put(validCustomer.getEmail(), validCustomer);
						System.out.println("Account created Successfully");
						break;

					case 2:
						System.out.println("Enter email and password id");
						String key = validateEmailAndPass(sc.next(), sc.next(), custMap);
						System.out.println(custMap.get(key));
						System.out.println("You are Logged in");
						break;

					case 3:
						System.out.println("Enter your email and old pass password ");
						key = validateEmailAndPass(sc.next(), sc.next(), custMap);
						System.out.println("Enter new Password");
						custMap.get(key).setPassword(sc.next());
						System.out.println("Password has been changed successfully");

						break;

					case 4:
						custMap.entrySet().forEach(s -> System.out.println(s));
						break;

					case 5:
						System.out.println("Enter email");
						String s = sc.next();
						validateEmail(s, custMap);
						for (Map.Entry<String, Customer> pair : custMap.entrySet())
							if (pair.getKey().equals(s))
								System.out.println(pair.getValue());
						System.out.println();

						break;

					case 6:
						System.out.println("Enter Email to remove account");
						removeByEmail(sc.next(), custMap);
						System.out.println("Account has been removed scuccessfully");
						break;
					case 7:
						System.out.println("Enter email");
						unSubscibe(sc.next(), custMap);
						break;
					case 8:
						for (ServicePlan b : ServicePlan.values())
							System.out.println(b + "@" + b.getPrice());

						System.out.println("Enter your email and Plan");

						changePlan(sc.next(), sc.next(), custMap);
						System.out.println("Plan Updated Successfully");

						break;

					case 9:
//						SORT BY EMAIL
						Map<String, Customer> treeMap = new TreeMap<String, Customer>(custMap);
						treeMap.entrySet().forEach(entry -> System.out.println(entry));
						break;
					case 10:
						List<Map.Entry<String, Customer>> sortByDate = new ArrayList<>(custMap.entrySet());
						Collections.sort(sortByDate, (entry1, entry2) -> {
							LocalDate d1 = entry1.getValue().getDob();
							LocalDate d2 = entry1.getValue().getDob();
							return d1.compareTo(d2);
						});
						for (Map.Entry<String, Customer> entry : sortByDate) {
							System.out.println(entry.getValue());
						}
					case 0:
						exit = true;
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}

		}

	}

}
