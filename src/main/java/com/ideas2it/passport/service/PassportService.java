package com.ideas2it.passport.service;

import com.ideas2it.Model.Passport;
import com.ideas2it.customizedexception.EmployeeException;

/**
 *This class is an interface of the passportserviceimpl  
 */
public interface PassportService {

    /**
    *This method acts as mediator to dao to insert passport details into the database 
    *@param passport - object of the class passport.
    *@throws employeeexception
    */
    public void addPassport(Passport passport) throws EmployeeException;
   
    /**
    *This method acts as mediator to the dao to retrieve passport details from the database.
    *@param id - unique identifier of the class passport
    *@throws employeeexception.
    */
    public Passport getPassport(int id)throws EmployeeException;
}