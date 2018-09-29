package com.Validation;

import java.util.regex.Pattern;

public class Validation {

	/**
	 * nameValidation - Validation of first and last name text input using regex
	 * - which only accept A-Z and a-z as input in text field check whether the
	 * length of input is greater than 2 and sastisfy regex or not.
	 */
	public boolean nameValidation(String name) {
		return Pattern.compile("^[A-Z,a-z]+$").matcher(name).matches()
				&& name.length() > 2 ? true : false;
	}

	/**
	 * 
	 */
	public boolean ageValidation(int age) {
		return age > -1 && age < 100 ? true : false;
	}

	/**
	 * mailValidation - Validation of email text input using regex - which only
	 * accept email as input in text field check whether input sastisfy regex or
	 * not.
	 */
	public boolean mailValidation(String email) {
		return Pattern
				.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
						Pattern.CASE_INSENSITIVE).matcher(email).matches() ? true
				: false;
	}

	/**
	 * validatePassword - Validation of passowrd input using regex - which only
	 * accept atleast 1 Captial 1 small alphabet and 1 number and special
	 * character as input in text field check whether input sastisfy regex or
	 * not.
	 */
	public boolean validatePassword(String password, String repeatPassword) {
		if (password.equals(repeatPassword)) {
			return Pattern
					.compile(
							"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,20}$")
					.matcher(password).matches() ? true : false;
		} else {
			System.out.println("Password is incorrect");
			return false;
		}
	}

	/**
	 * validatePassword - Validation of password input using regex - which only
	 * accept atleast 1 Capital 1 small alphabet and 1 number and special
	 * character as input in text field check whether input satisfy regex or
	 * not.
	 */
	public boolean validateContact(String contact) {
		return contact.length() > 8 ? true : false;
	}
}
