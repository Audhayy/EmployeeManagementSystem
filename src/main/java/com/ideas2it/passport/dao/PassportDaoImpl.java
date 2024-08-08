package com.ideas2it.passport.dao;


import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
<<<<<<< HEAD:com/passport/dao/PassportDaoImpl.java

=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/passport/dao/PassportDaoImpl.java


import com.ideas2it.Model.Passport;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Connection.HibernateManager;

/**
 *This class is the repository of the project.
 */ 
public class PassportDaoImpl implements PassportDao {

    /**
     * *This method is used to insert project into the database
    *@param passport - object of the class passport
     *@throws EmployeeException - exception while adding passport
    */ 
    public void addPassport(Passport passport) throws EmployeeException{
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
<<<<<<< HEAD:com/passport/dao/PassportDaoImpl.java
=======

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/passport/dao/PassportDaoImpl.java
            transaction = session.beginTransaction();
            Integer id = (Integer) session.save(passport);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while adding passport" + passport.getpassportNumber() + e.getMessage(), e);
        }
    }
   /**
    *This method is used to obtain project into  the database
    *@param id - unique identifier of the passport class
    * @throws EmployeeException- exception while retrieving passport details
    */ 
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
            if(null!= session) {
                session.close();
            }
        } 
        return passport;
    }
}