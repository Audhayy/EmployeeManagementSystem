package com.passport.service;

import com.Model.Passport;
import com.customizedexception.EmployeeException;


public interface PassportService {

    public void addPassport(Passport passport) throws EmployeeException;
    public Passport getPassport(int id)throws EmployeeException;
}