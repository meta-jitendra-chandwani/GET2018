package com.controller;

import java.io.FileNotFoundException;
import java.util.Date;

import com.facade.HelperFacade;

public class Controller {
    private HelperFacade helperFacade = HelperFacade.getInstance();

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
	public boolean insertion(String fName,String lName,int age,Date date,String contact_number, String mail,String password,String organization) throws FileNotFoundException{
		return helperFacade.insertionOfData(fName,lName,age,date,contact_number,mail,password,organization);
	}
}
