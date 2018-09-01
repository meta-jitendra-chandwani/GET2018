package com.DAO;

public class Query {
	public final static String INSERT="Insert into User values(?,?,?,?,?,?,?,?,?)";
	public final static String SELECT_PASSWORD="Select Password from User Where Email=?";
	public final static String SELECT_IMAGE="Select Image from User Where Email=?";
	public final static String SELECT_USER_NAME="Select First_Name,Last_Name from User Where Email=?";

	
}