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
@Table(name = "job_detail")
public class Job_detail {

	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobDetailId;

	@Column(name = "emp_code")
	private String employeeCode;

	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateOfJoining;

	@Column(name = "total_exp")
	private int experience;

	@Column(name = "job_code")
	private int jobCode;

	@Column(name = "reporting_mgr")
	private int reportingManager;

	@Column(name = "team_lead")
	private int techLead;

	@Column(name = "curr_proj_id")
	private int currentProjectId;

	public int getJobDetailId() {
		return jobDetailId;
	}

	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getDateOfJoining() {
		return DateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	public int getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}

	public int getTechLead() {
		return techLead;
	}

	public void setTechLead(int techLead) {
		this.techLead = techLead;
	}

	public int getCurrentProjectId() {
		return currentProjectId;
	}

	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}

}
