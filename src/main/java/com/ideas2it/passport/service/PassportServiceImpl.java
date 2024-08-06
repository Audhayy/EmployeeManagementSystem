package com.ideas2it.passport.service;

import com.ideas2it.Model.Passport;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.passport.dao.PassportDao;
import com.ideas2it.passport.dao.PassportDaoImpl;

public class PassportServiceImpl implements PassportService {
    PassportDao passportDao = new PassportDaoImpl();
    
    @Override
    public void addPassport(Passport passport) throws EmployeeException{
        passportDao.addPassport(passport);
    }
    @Override
    public Passport getPassport(int id)throws EmployeeException {
        return passportDao.getPassport(id);
    }
}