package SortingSystem;

public class Employee implements Comparable<Employee> {
	private String firstName;
	private String lastName;
	private int socialSecurityNumber;
	
	public Employee(String firstName, String lastName, int ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		socialSecurityNumber = ssn;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setSocialSecurityNumber(int ssn) {
		socialSecurityNumber = ssn;
	}

	public int getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	public int compareTo(Employee employee) {
		return socialSecurityNumber - employee.getSocialSecurityNumber();
	}
}
