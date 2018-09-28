package com.DAO;

public class Query {
	public final static String INSERT="Insert into EmployeeDetails values(?,?,?,?)";
	public final static String SELECT_EPMLOYEE="Select FirstName,LastName,Age,Email from EmployeeDetails Where FirstName=? and LastName=?";
	public final static String SELECT_ALL_EMPLOYEE="Select FirstName,LastName,Age,Email from EmployeeDetails";
	public final static String UPDATE_EMPLOYEE_DETAILS="UPDATE EmployeeDetails SET FirstName=?,LastName=?,Age=? WHERE Email=?";
	public final static String SELECT_EPMLOYEE_BY_EMAIL="Select FirstName,LastName,Age,Email from EmployeeDetails Where Email=?";

}
