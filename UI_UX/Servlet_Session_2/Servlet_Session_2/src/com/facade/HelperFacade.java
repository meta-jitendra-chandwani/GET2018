package com.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DAO.JDBCConnection;
import com.DAO.Query;
import com.model.UserEntity;

public class HelperFacade {
	private static List<UserEntity> UserList=new ArrayList<UserEntity>();
	
	private HelperFacade(){
		//for singleton
	}
	
	private static HelperFacade helperFacade = new HelperFacade();

	/**
	 * 
	 * @return
	 */
	public static HelperFacade getInstance() {
		return helperFacade;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static List<UserEntity> getUserList() {
		return UserList;
	}

	public String getUserName(String emailId) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultPass=null;
		String f_name=null;
		String l_name=null;
		String full_name=null;
		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn.prepareStatement(Query.SELECT_USER_NAME);
			preparedStatement.setString(1, emailId);
			resultPass = preparedStatement.executeQuery();

			if (resultPass.next()) {
				f_name = resultPass.getString(1);
				l_name = resultPass.getString(2);
				full_name=f_name+" "+l_name;
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return full_name;		
	}


	public byte[] getProfilePicture(String emailId){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultPass=null;
		Blob image = null;
		byte[] imgData = null;

		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn.prepareStatement(Query.SELECT_IMAGE);
			preparedStatement.setString(1, emailId);
			resultPass = preparedStatement.executeQuery();

			if (resultPass.next()) {
				image = resultPass.getBlob(1);
				imgData = image.getBytes(1, (int) image.length());
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return imgData;

	}
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param age
	 * @param date
	 * @param contact_number
	 * @param mail
	 * @param password
	 * @param organization
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean insertionOfData(String fName, String lName, int age,
			Date date, String contact_number, String mail, String password,
			String organization) throws FileNotFoundException {
		
		
		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		FileInputStream inputStream = null;

		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn.prepareStatement(Query.INSERT);

			File image = new File("C:\\Users\\User23\\workspace\\Servlet_Session_2\\src\\com\\DefaultImage\\defaultImage.png");
			inputStream = new FileInputStream(image);
			
			UserList.add(new UserEntity(fName, lName, age, mail, date, contact_number, password, organization, inputStream));
			
			if (conn != null) {
				preparedStatement.setString(1, fName);
				preparedStatement.setString(2, lName);
				preparedStatement.setInt(3, age);
				preparedStatement.setDate(4, (java.sql.Date) date);
				preparedStatement.setString(5, contact_number);
				preparedStatement.setString(6, mail);
				preparedStatement.setString(7, password);
				preparedStatement.setString(8, organization);
				preparedStatement.setBinaryStream(9, inputStream,
						(int) (image.length()));

				int result = preparedStatement.executeUpdate();
				if (result > 0) {
					returnValue = true;
					System.out.println("Registered");
				}
			} else {
				System.out.println("!!Connection Error!!");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return returnValue;
	}
}
