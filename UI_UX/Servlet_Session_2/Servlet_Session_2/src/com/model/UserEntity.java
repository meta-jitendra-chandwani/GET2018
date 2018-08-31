package com.model;

import java.io.FileInputStream;
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
	private FileInputStream image;

	public UserEntity(String firstName, String lastName, int age, String email,
			Date date, String contact_number, String password,
			String organisation, FileInputStream image) {
		this.email=email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.date = date;
		this.contact_number = contact_number;
		this.password = password;
		this.organisation = organisation;
		this.image = image;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return email;
	}

	public Date getDate() {
		return date;
	}

	public String getContact_number() {
		return contact_number;
	}

	public String getPassword() {
		return password;
	}

	public String getOrganisation() {
		return organisation;
	}

	public FileInputStream getImage() {
		return image;
	}

}