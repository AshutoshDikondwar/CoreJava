package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import CustomerException.CustomerException;

import static Utils.ValidationRules.*;
import customer.Customer;
import customer.ServicePlan;

public class CustomerManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Customer> list = new ArrayList<>();
			boolean exit = false;

			while (!exit) {
				System.out.println(
						"1: Sign up, 2: Sign in, 3: Change password, 4: Display All Customers, 5: Search by email, 6: Remove by email, 7: Unsubscribe Customer, 8:Change plan,  9: exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(" name,  lastName,  email,  password,  regAmount,  dob, plan");
						for (ServicePlan s : ServicePlan.values())
							System.out.println(s);
						Customer validateCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), list);
						list.add(validateCustomer);
						System.out.println("You Account has been created");
						break;
					case 2:
						System.out.println("Enetr email and Password");
						int index = validateEmailAndPass(sc.next(), sc.next(), list);
						System.out.println("Your Logged in: ");
						System.out.println(list.get(index));
						break;
					case 3:
						System.out.println("Enter email id and Old Password");
						index = validateEmailAndPass(sc.next(), sc.next(), list);
						System.out.println("Enter New Password");
						list.get(index).setPassword(sc.next());
						break;
					case 4:
						System.out.println("Customer list");
						for (Customer c : list)
							System.out.println(c);
						break;
					case 5:
						System.out.println("Enter email");
						index = validateEmail(sc.next(), list);
						System.out.println(list.get(index));
						break;
					case 6:
						System.out.println("Enter email");

						String email = sc.next();
						Iterator<Customer> cid = list.iterator();
						while (cid.hasNext())
							if (cid.next().getEmail().equals(email))
								cid.remove();
						System.out.println("Removed Successfully");

						break;
					case 7:
						System.out.println("Enter email id and Password");
						index = validateEmailAndPass(sc.next(), sc.next(), list);
						list.get(index).setPlan(null);
						list.get(index).setRegAmount(0);
						System.out.println("You do not have any subscription");
						break;
					case 8:
						System.out.println("Enter email id and Password");
						index = validateEmailAndPass(sc.next(), sc.next(), list);
						for (ServicePlan s : ServicePlan.values())
							System.out.println(s);
						ServicePlan changePlan = parseAndValidatePlan(sc.next());
						list.get(index).setPlan(changePlan);
						list.get(index).setRegAmount(changePlan.getPrice());
						System.out.println("Your Plan Changed to" + changePlan);
						break;

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
