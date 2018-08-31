package com.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DAO.JDBCConnection;
import com.DAO.Query;
import com.model.UserEntity;;

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
				System.out.println("Connection In");
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
