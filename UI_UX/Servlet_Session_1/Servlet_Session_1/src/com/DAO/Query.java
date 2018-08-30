package com.DAO;

public class Query {
	public final static String INSERT="Insert into EmployeeDetails values(?,?,?,?)";
	public final static String SELECT_EPMLOYEE="Select * from EmployeeDetails Where FirstName=? and LastName=?";
	public final static String SELECT_ALL_EMPLOYEE="Select * from EmployeeDetails";
	public final static String UPDATE_EMPLOYEE_DETAILS="UPDATE EmployeeDetails SET FirstName=?,LastName=?,Age=? WHERE Email=?";
	public final static String SELECT_EPMLOYEE_BY_EMAIL="Select * from EmployeeDetails Where Email=?";

}
