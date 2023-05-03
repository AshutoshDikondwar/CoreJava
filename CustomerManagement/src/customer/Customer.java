package customer;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	public static int idGenerator;

	public Customer(String name, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		++idGenerator;
		this.id = idGenerator;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public Customer(String email) {
		this.email = email;
	}

	public Customer(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public boolean equals(Object o) {
		System.out.println("in customer equals");
		if (o instanceof Customer)
			return (this.email).equals(((Customer) o).email);
		return false;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", regAmount="
				+ regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}

}
