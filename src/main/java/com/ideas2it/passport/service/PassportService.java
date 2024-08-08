package com.ideas2it.passport.service;

import com.ideas2it.Model.Passport;
import com.ideas2it.customizedexception.EmployeeException;

/**
 *This class is an interface of the passport service impl
 */
public interface PassportService {

    /**
    *This method acts as mediator to dao to insert passport details into the database 
    *@param passport - object of the class passport.
<<<<<<< HEAD:com/passport/service/PassportService.java
    *@throws EmployeeException - exception while adding passport
=======
    *@throws EmployeeException when unable to insert a passport detail
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/passport/service/PassportService.java
    */
    void addPassport(Passport passport) throws EmployeeException;
   
    /**
    *This method acts as mediator to the dao to retrieve passport details from the database.
    *@param id - unique identifier of the class passport
<<<<<<< HEAD:com/passport/service/PassportService.java
    *@throws EmployeeException- exception while retrieving passport details
=======
    *@throws EmployeeException when unable to extract passport
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/passport/service/PassportService.java
    */
    Passport getPassport(int id)throws EmployeeException;
}