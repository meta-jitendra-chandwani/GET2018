package com.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.JDBCConnection;
import com.DAO.Query;
import com.model.UserEntity;

public class HelperFacade {
	private static List<UserEntity> UserList = new ArrayList<UserEntity>();

	private HelperFacade() {
		// for singleton
	}
	private static HelperFacade helperFacade = new HelperFacade();


	/**
	 * getUserDetailsByEmail - get user details by email id
	 * @param email
	 * @return User Entity object
	 */
	public UserEntity getUserDetailsByEmail(String email) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultPass = null;
		UserEntity user = null;
		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn.prepareStatement(Query.SELECT_ALL);
			preparedStatement.setString(1, email);
			resultPass = preparedStatement.executeQuery();

			if (resultPass.next()) {
				user = new UserEntity(resultPass.getString(1),
						resultPass.getString(2), resultPass.getInt(3),
						resultPass.getDate(4), resultPass.getString(5),
						resultPass.getString(6), resultPass.getString(7),
						resultPass.getString(8), resultPass.getBinaryStream(9));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return user;

	}

	
	/**
	 * 
	 * @return
	 */
	public static HelperFacade getInstance() {
		return helperFacade;
	}

	/**
	 * getUserList - get user list
	 * @return UserList
	 */
	public static List<UserEntity> getUserList() {
		return UserList;
	}

	/**
	 * getUserName - get user name of particular user 
	 * @param emailId - email id of user
	 * @return - name of user if exist in database
	 */
	public String getUserName(String emailId) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultPass = null;
		String f_name = null;
		String l_name = null;
		String full_name = null;
		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn.prepareStatement(Query.SELECT_USER_NAME);
			preparedStatement.setString(1, emailId);
			resultPass = preparedStatement.executeQuery();

			if (resultPass.next()) {
				f_name = resultPass.getString(1);
				l_name = resultPass.getString(2);
				full_name = f_name + " " + l_name;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return full_name;
	}

	/**
	 * getProfilePicture - get profile picture of user
	 * @param emailId - email id of user
	 * @return - byte array of profile media
	 */
	public byte[] getProfilePicture(String emailId) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultPass = null;
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
		} catch (Exception e) {
			e.getStackTrace();
		}
		return imgData;

	}

	/**
	 * insertionOfData - insertion of user data 
	 * @param user - user entity object
	 * @return true if updated else false
	 * @throws FileNotFoundException
	 */
	public boolean insertionOfData(UserEntity user)
			throws FileNotFoundException {

		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		FileInputStream inputStream = null;

		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn.prepareStatement(Query.INSERT);

			File image = new File(
					"C:\\Users\\User23\\workspace\\Servlet_Session_2\\src\\com\\DefaultImage\\defaultImage.png");
			inputStream = new FileInputStream(image);

			UserList.add(user);

			if (conn != null) {
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setInt(3, user.getAge());
				preparedStatement.setDate(4, (java.sql.Date) user.getDate());
				preparedStatement.setString(5, user.getContact_number());
				preparedStatement.setString(6, user.getMailId());
				preparedStatement.setString(7, user.getPassword());
				preparedStatement.setString(8, user.getOrganisation());
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

	/**
	 * setProfilePicture - set profile picture of user
	 * @param filename - file name
	 * @param path - path of file
	 * @param emailId - email id of user
	 * @return true if updated else false
	 */
	public boolean setProfilePicture(String filename, String path,
			String emailId) {
		Connection conn = null;

		PreparedStatement preparedStatement = null;
		boolean resultPass = false;
		FileInputStream inputStream = null;
		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");

			File image = new File(path + File.separator + filename);
			inputStream = new FileInputStream(image);

			preparedStatement = conn.prepareStatement(Query.UPDATE_IMAGE);
			preparedStatement.setBinaryStream(1, inputStream,
					(int) (image.length()));
			preparedStatement.setString(2, emailId);

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				resultPass = true;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return resultPass;
	}

	/**
	 * updateUserDetails - update user details
	 * @param user - object of user entity
	 * @return true if updated else false
	 */
	public boolean updateUserDetails(UserEntity user) {
		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn
					.prepareStatement(Query.Update_User_Details);

			if (conn != null) {
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setInt(3, user.getAge());
				preparedStatement.setDate(4, (java.sql.Date) user.getDate());
				preparedStatement.setString(5, user.getContact_number());
				preparedStatement.setString(6, user.getOrganisation());
				preparedStatement.setString(7, user.getMailId());

				int result = preparedStatement.executeUpdate();
				if (result > 0) {
					returnValue = true;
					System.out.println("Updated");
				}
			} else {
				System.out.println("!!Connection Error!!");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return returnValue;

	}

	/**
	 * getFriendListOfUser - get friend list of user
	 * @param email - email id of user
	 * @param organisation - organisation of user
	 * @return list of user entity
	 */
	public List<UserEntity> getFriendListOfUser(String email,
			String organisation) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<UserEntity> friendList = null;
		try {
			conn = JDBCConnection.getDatabaseConnection("Metacube_Database",
					"root", "root");
			preparedStatement = conn
					.prepareStatement(Query.Update_User_Details);
			friendList = new ArrayList<UserEntity>();
			UserEntity user = null;

			preparedStatement = conn.prepareStatement(Query.GET_FRIEND_LIST);
			preparedStatement.setString(1, organisation);
			preparedStatement.setString(2, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				do {
					user = new UserEntity(resultSet.getString(1),
							resultSet.getString(2), resultSet.getInt(3),
							resultSet.getDate(4), resultSet.getString(5),
							resultSet.getString(6), resultSet.getString(7),
							resultSet.getString(8),
							resultSet.getBinaryStream(9));
					friendList.add(user);
				} while (resultSet.next());
				return friendList;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friendList;
	}
}