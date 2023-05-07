package customer;

import java.time.LocalDate;

public class Customer {

	private int custId;
	private String name, lastName, email, password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	public static int idGenerator;

	public Customer(String name, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		++idGenerator;
		this.custId = idGenerator;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public Customer(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public int getCustId() {
		return custId;
	}

//	In HashMap we don't need to override equals and hashCOde becoz hashMap works on key which is already unique

//	@Override
//	public boolean equals(Object o) {
//		if (o instanceof Customer)
//			return this.email.equals(((Customer) o).email);
//		return false;
//	}
//
//	@Override
//	public int hashCode() {
//		return this.email.hashCode();
//	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}

}
