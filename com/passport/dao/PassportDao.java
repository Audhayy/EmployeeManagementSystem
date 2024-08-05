package com.passport.dao;

import com.Model.Passport;
import com.customizedexception.EmployeeException;


public interface PassportDao {

    public void addPassport(Passport passport) throws EmployeeException;
    public Passport getPassport(int id)throws EmployeeException;
}