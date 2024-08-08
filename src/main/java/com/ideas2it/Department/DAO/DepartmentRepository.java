package com.ideas2it.Department.DAO;

<<<<<<< HEAD:com/Department/DAO/DepartmentRepository.java
import org.hibernate.HibernateException;
=======
import org.hibernate.HibernateException; 
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/DAO/DepartmentRepository.java
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:com/Department/DAO/DepartmentRepository.java
import com.Model.Department;
import com.customizedexception.EmployeeException;
import com.Connection.HibernateManager;
=======

import com.ideas2it.Model.Department;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Connection.HibernateManager;
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/DAO/DepartmentRepository.java

/**
 *<p>This class  is where the details presented 
 *by the user gets stored,retrieved and altered.
 *</p>
 */
public class DepartmentRepository{
<<<<<<< HEAD:com/Department/DAO/DepartmentRepository.java
    List<Department> departmentList = new ArrayList<>();

        public boolean checkDepartment() {
            return departmentList.isEmpty();
        }
=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/DAO/DepartmentRepository.java

   /**
    *<p>This method is used to add the department
    *details in the department list.
    *</p>
    *@param departmentName -name of the department
    *@throws EmployeeException throws while department details cannot be into the database
    */
    public void insertDepartment(String departmentName) throws EmployeeException{
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Department department = new Department(departmentName);
            Integer id = (Integer) session.save(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while adding department of name : " + departmentName + e.getMessage(), e);
        }
    }

   /**
    *<p>
    *This method is used to display details corresponding to the id.
    *details in the department db.
    *</p>
    *@param id - unique identifier of the department 
    *@throws EmployeeException throws while department details cannot be retrieved the database
    */
    public Department getDepartmentById(int id) throws EmployeeException{
        Transaction transaction = null;
        Department department = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            department = session.get(Department.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while fetching department of id : " + id , e);
<<<<<<< HEAD:com/Department/DAO/DepartmentRepository.java
        } finally {
            if(null!= session) {
                session.close();
            }
        } 
=======
        }
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/DAO/DepartmentRepository.java
        return department;

    }

   /**
    *<p>
    *This method is used to show all the details 
    *present in department
    *</p>
    *@throws EmployeeException throws while all department details cannot be retrieved from the database
    */
    public List<Department> getAllDepartments() throws EmployeeException{
        List<Department> departmentList = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Department> query = session.createQuery("FROM Department", Department.class);
            departmentList = query.list();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while fetching available departments : " ,e);
<<<<<<< HEAD:com/Department/DAO/DepartmentRepository.java
        } finally {
            if(null!= session) {
                session.close();
            }
=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/DAO/DepartmentRepository.java
        }
        return departmentList;

                 
    } 

   /**
    * <p>
    * This method is used to check if the new 
    * and old id matches and then update the new details
    * </p>
    * @param department - object of the department
    * @throws EmployeeException throws while department details cannot be updated the database
    */
    public void updateDepartment( Department department) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while updating the employee with id:" + department.getDepartmentId(), e);
        }

    }

   /**
    *<p>
    *This method is used to remove  
    *and calls to check the validity by matching constraints
    *<p>
    *@param id - unique identifier of the department
    *@throws EmployeeException throws while department details cannot be deleted the database
    */
<<<<<<< HEAD:com/Department/DAO/DepartmentRepository.java
    public void deleteDepartment(int id) throws EmployeeException {
=======
    public void deleteDepartment(int id) throws EmployeeException{
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/DAO/DepartmentRepository.java
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE FROM Department WHERE Departmentid = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {

            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while deleting department of id : " + id, e);
        }

    }
    
}