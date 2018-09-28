package com.DAO;

public class Query {
	public final static String INSERT = "Insert into User values(?,?,?,?,?,?,?,?,?)";
	public final static String SELECT_PASSWORD = "Select Password from User Where Email=?";
	public final static String SELECT_IMAGE = "Select Image from User Where Email=?";
	public final static String SELECT_USER_NAME = "Select First_Name,Last_Name from User Where Email=?";
	public final static String UPDATE_IMAGE = "Update User SET Image = ? where Email=?";
	public final static String Update = "Update User SET Age = ? where Email LIKE ?";
	public final static String SELECT_ALL = "SELECT First_Name,Last_Name,Age,DOB,Mobile_Number,Email,Password,Organization,Image FROM User WHERE Email = ?";
	public final static String Update_User_Details = "Update User SET First_Name=?,Last_Name=?,Age=?,DOB=?,Mobile_Number=?,Organization=? Where Email=?";
	public static final String GET_FRIEND_LIST = "SELECT First_Name,Last_Name,Age,DOB,Mobile_Number,Email,Password,Organization,Image FROM user WHERE organization = ? AND email <> ?";

}