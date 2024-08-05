package com.passport.dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Model.Passport;
import com.customizedexception.EmployeeException;
import com.Connection.HibernateManager;


public class PassportDaoImpl implements PassportDao {

    public void addPassport(Passport passport) throws EmployeeException{
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Integer id = (Integer) session.save(passport);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while adding passport" + passport.getpassportNumber() + e.getMessage(),e);
        } finally {
            session.close();
        }
    }
    public Passport getPassport(int id)throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        Passport passport = null;
        try {
            transaction = session.beginTransaction();
            passport = session.get(Passport.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while fetching passport" + id , e);
        } finally {
            session.close();
        } 
        return passport;
    }
}