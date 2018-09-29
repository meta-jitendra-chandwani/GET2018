package com.controller;

import java.io.FileNotFoundException;
import java.util.List;

import com.facade.HelperFacade;
import com.model.UserEntity;

/**
 * 
 * @author Jitendra Chandwani
 *
 */
public class Controller {
    private HelperFacade helperFacade = HelperFacade.getInstance();
    
    /**
     * insertion - insertion of user data in db
     * @param user
     * @return
     * @throws FileNotFoundException
     */
	public boolean insertion(UserEntity user) throws FileNotFoundException{
		return helperFacade.insertionOfData(user);
	}
	
	/**
	 * getFriendListOfUser - get friend of user
	 * @param email - email id of user
	 * @param organisation - organisation of user
	 * @return true if exist else false
	 */
	public List<UserEntity> getFriendListOfUser(String email,String organisation){
		return helperFacade.getFriendListOfUser(email,organisation);
	}
	
	/**
	 * getProfilePicture - get profile picture of user
	 * @param emailId - email id of user
	 * @return - byte array of profile media
	 */
	public byte[] selectProfilePicture(String emailId){
		return helperFacade.getProfilePicture(emailId);
	}
	
	/**
	 * selectUser -  select user details of particular email id
	 * @param emailId
	 * @return return object of UserEntity
	 */
	public UserEntity selectUser(String emailId){
		return helperFacade.getUserDetailsByEmail(emailId);
	}
	
	/**
	 * selectUserName - select user name of particular email id
	 * @param emailId - user email id
	 * @return user name of email id
	 */
	public String selectUserName(String emailId){
		return helperFacade.getUserName(emailId);
	}
	
	/**
	 * updateImage  -  update user image
	 * @param filename - image name
	 * @param path	- path
	 * @param emailId	- user email id 
	 * @return true if updated else false
	 */
	public boolean updateImage(String filename,String path,String emailId){
		return helperFacade.setProfilePicture(filename,path,emailId);
	}

	/**
	 * updateUserDetails - update the user details in database
	 * @param user - list of user
	 * @return true if update successfully else false 
	 */
	public boolean updateUserDetails(UserEntity user) {
		return helperFacade.updateUserDetails(user);
	}
}
