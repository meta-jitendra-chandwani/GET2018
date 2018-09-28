package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "emp_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_code;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "middle_name")
	private String middle_name;

	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "primary_contact_number")
	private String primary_contact_number;
	
	@Column(name = "secondary_contact_number")
	private String secondary_contact_number;
	
	@Column(name = "email_id")
	private String email_id;
	
	@Column(name = "skype_id")
	private String skype_id;
	
	@Column(name = "profile_picture")
	private String profile_picture;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "skills")
	private String skills;
	
	@Column(name = "enable")
	private Boolean enable = true;

	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrimary_contact_number() {
		return primary_contact_number;
	}

	public void setPrimary_contact_number(String primary_contact_number) {
		this.primary_contact_number = primary_contact_number;
	}

	public String getSecondary_contact_number() {
		return secondary_contact_number;
	}

	public void setSecondary_contact_number(String secondary_contact_number) {
		this.secondary_contact_number = secondary_contact_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getSkype_id() {
		return skype_id;
	}

	public void setSkype_id(String skype_id) {
		this.skype_id = skype_id;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
}
