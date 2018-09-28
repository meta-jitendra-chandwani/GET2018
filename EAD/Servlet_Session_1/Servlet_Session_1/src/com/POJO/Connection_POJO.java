package com.POJO;


/**
 * Connection POJO - For set and get the value of Order_Id, Order_Date and Order_Total
 * @author Jitendra Chandwani
 *
 */
public class Connection_POJO {
	private String firstName;
	private String lastName;
	private int age;
	private String email;

	public Connection_POJO(String firstName,String lastName,int age,String email) {
		this.firstName = firstName;
		this.lastName=lastName;
		this.age = age;
		this.email = email;		
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	
}
