package com.model;

import java.io.InputStream;
import java.util.Date;

public class UserEntity {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private Date date;
	private String contact_number;
	private String password;
	private String organisation;
	private InputStream image;

	public UserEntity(String firstName, String lastName, int age, Date date,
			String contact_number, String email, String password,
			String organisation, InputStream image) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.date = date;
		this.contact_number = contact_number;
		this.password = password;
		this.organisation = organisation;
		this.image = image;
	}

	/**
	 * getFirstName - get First Name
	 * @return last name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * getLastName - get last Name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * getAge - get age
	 * @return - age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * getDate - get Date
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * getContact_number - get contact number
	 * @return - contact number
	 */
	public String getContact_number() {
		return contact_number;
	}

	/**
	 * getPassword - get user password
	 * @return - user password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * getOrganisation - get organisation Name
	 * @return - organisation Name
	 */
	public String getOrganisation() {
		return organisation;
	}

	/**
	 * getImage - get User Image
	 * @return - User Image
	 */
	public InputStream getImage() {
		return image;
	}
	
	/**
	 * getMailId - get mail id
	 * @return email
	 */
	public String getMailId(){
		return email;
	}

}