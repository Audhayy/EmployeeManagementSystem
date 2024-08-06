package com.ideas2it.passport.dao;

import com.ideas2it.Model.Passport;
import com.ideas2it.customizedexception.EmployeeException;

/**
 *This class is an interface of the passportdaoimpl.  
 */
public interface PassportDao {

     /**
    *This method is used to insert passport details into the database 
    *@param passport - object of the class passport.
    *@throws employeeexception
    */
    public void addPassport(Passport passport) throws EmployeeException;

    /**
    *This method is used to retrieve passport details from the database.
    *@param id - unique identifier of the class passport
    *@throws employeeexception.
    */
    public Passport getPassport(int id)throws EmployeeException;
}