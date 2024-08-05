package com.Employee.DAO;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import org.hibernate.Session; 

import org.hibernate.Hibernate;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Model.Employee;
import com.Model.Department;
import com.Model.Project;
import com.Project.DAO.ProjectRepository;
import com.customizedexception.EmployeeException;
import com.Connection.HibernateManager;

/**
 *<p>
 * This class is where the employee details are stored
 *operations such as retrieval and insertion are done here.
 *this class predominantly connects with employee service .
 * @Author Audhithiyah
 *</p>
 */
public class EmployeeRepositoryImpl implements EmployeeRepository{
    List<Employee> employees = new ArrayList<>();    

    public void addEmployee(Employee employee) throws EmployeeException {
       Session session = HibernateManager.getFactory().openSession();
       Transaction transaction = null;
       try {
           transaction = session.beginTransaction();
           Integer id = (Integer) session.save(employee);
           transaction.commit();
       } catch (HibernateException e) {
           if(transaction!= null) {
               transaction.rollback();
           }
           throw new EmployeeException("Error while adding employee:" +employee.getEmployeeName() ,e);
       } finally {
           session.close();
       }
    }
        
    public List<Employee> getAllEmployees() throws EmployeeException {       
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        List<Employee> employeeRecords = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query<Employee>query = session.createQuery("FROM Employee WHERE softDelete = false", Employee.class);
            employeeRecords = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction!= null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new EmployeeException("Error while reading employee:",e);
        } finally {
           session.close();
        }
        return employeeRecords;
    }


    public void updateEmployee(Employee employee) throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction!= null) {
                transaction.rollback();
            } 
            throw new EmployeeException("Error while updating the employee with id:" + employee.getEmployeeId(),e);
        } finally {
            session.close();
        }    

       
    }
    
    public Employee getEmployeeById(int employeeId) throws EmployeeException {
       Session session = HibernateManager.getFactory().openSession();
       Transaction transaction = null;
       Employee employee = null;
       try {
           transaction = session.beginTransaction();
           employee = session.get(Employee.class, employeeId);
           transaction.commit();
       } catch(HibernateException e) {
           if(transaction!=null) {
               transaction.rollback(); 
           }
           throw new EmployeeException("Error while retrieving employees of department id:" +employeeId,e);
       } finally {
           session.close();      
       }
       return employee;
    }
    
    public void deleteEmployee(int id) throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String deleteQuery = "UPDATE employee SET is_deleted = :softDelete WHERE id = ;deleteId";
            Query<?>query = session.createQuery(deleteQuery);
            query.setParameter("is_deleted", true);
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction!=null) {
              transaction.rollback();
          }
          throw new EmployeeException("Error while deleting employee with the id:" +id ,e);
      } finally {
          session.close();
        }          
      }

    }
      
    
    