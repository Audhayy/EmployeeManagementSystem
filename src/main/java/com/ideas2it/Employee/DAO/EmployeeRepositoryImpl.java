package com.ideas2it.Employee.DAO;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

<<<<<<< HEAD:com/Employee/DAO/EmployeeRepositoryImpl.java
import com.Model.Employee;
import com.customizedexception.EmployeeException;
import com.Connection.HibernateManager;
=======
import com.ideas2it.Model.Employee;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Connection.HibernateManager;
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/DAO/EmployeeRepositoryImpl.java

/**
 *<p>
 * This class is where the employee details are stored
 *operations such as retrieval and insertion are done here.
 *this class predominantly connects with employee service .
<<<<<<< HEAD:com/Employee/DAO/EmployeeRepositoryImpl.java
 * @author  Audhithiyah
 *</p>
 */
public class EmployeeRepositoryImpl implements EmployeeRepository{
    public void addEmployee(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {

=======
 * @author Audhithiyah
 *</p>
 */
public class EmployeeRepositoryImpl implements EmployeeRepository{

    public void addEmployee(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/DAO/EmployeeRepositoryImpl.java
            transaction = session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while adding employee:" + employee.getEmployeeName(), e);
        }
    }
        
    public List<Employee> getAllEmployees() throws EmployeeException {
        Transaction transaction = null;
        List<Employee> employeeRecords;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Employee>query = session.createQuery("FROM Employee WHERE softDelete = false", Employee.class);
            employeeRecords = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction!= null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            throw new EmployeeException("Error while reading employee:",e);
<<<<<<< HEAD:com/Employee/DAO/EmployeeRepositoryImpl.java
        } finally {
           if(null!= session) {
               session.close();
           }
=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/DAO/EmployeeRepositoryImpl.java
        }
        return employeeRecords;
    }


    public void updateEmployee(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while updating the employee with id:" + employee.getEmployeeId(), e);
        }

       
    }
    public Employee getEmployeeById(int employeeId) throws EmployeeException {

       Transaction transaction = null;
       Employee employee = null;
       try (Session session = HibernateManager.getFactory().openSession()){
           transaction = session.beginTransaction();
           employee = session.get(Employee.class, employeeId);
           transaction.commit();
       } catch(HibernateException e) {
           if(transaction!=null) {
               transaction.rollback(); 
           }
           throw new EmployeeException("Error while retrieving employees of department id:" +employeeId,e);
<<<<<<< HEAD:com/Employee/DAO/EmployeeRepositoryImpl.java
       } finally {
           if(null!= session) {
           session.close(); 
           }     
=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/DAO/EmployeeRepositoryImpl.java
       }
       return employee;
    }
    
    public void deleteEmployee(int id) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            String deleteQuery = "UPDATE employee SET is_deleted = :softDelete WHERE id = ;deleteId";
            Query<?> query = session.createQuery(deleteQuery);
            query.setParameter("is_deleted", true);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while deleting employee with the id:" + id, e);
        }
      }
    }
      
    
    