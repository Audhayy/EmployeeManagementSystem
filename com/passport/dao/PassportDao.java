package com.passport.dao;

import com.Model.Passport;
import com.customizedexception.EmployeeException;

/**
 *This class is an interface of the passportdaoimpl.  
 */
public interface PassportDao {

     /**
    *This method is used to insert passport details into the database 
    *@param passport - object of the class passport.
    *@throws EmployeeException - throws exception when passport details cannot be added
    */
    public void addPassport(Passport passport) throws EmployeeException;

    /**
    *This method is used to retrieve passport details from the database.
    *@param id - unique identifier of the class passport
    *@throws EmployeeException-throws exception when unable to get passport details
    */
    public Passport getPassport(int id)throws EmployeeException;
}