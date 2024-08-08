package com.ideas2it.Employee.DAO;

import java.util.List;

import com.ideas2it.Model.Employee;
import com.ideas2it.customizedexception.EmployeeException;

/**
 *This interface has abstract methods for employeerepositoryimpl
 * @author Audhithiyah
 */
public interface EmployeeRepository {
  
    /**
     *<p>
     *This method is used to insert an employee detail into the database.
     *</p>
     *@param employee - objectof the employee class
     *@throws EmployeeException while inserting an employee
     */
    void addEmployee(Employee employee) throws EmployeeException;

    /**
     *<p>
     *This method retrieves all the employees that are stored
     *in the database
     *
     *@return employeeRecords -list of employees present in the database
     *@throws EmployeeException- when all the employees cannot be retrieved
     *</p>
     */
     List<Employee> getAllEmployees() throws EmployeeException;

   /**
    *<p>
    * This method is alters and changes the already stored data
    * in the database
    *
    * @param employee- Employee object of the class Employee
    *
    * @throws EmployeeException
    *</p> 
    */
    void updateEmployee(Employee employee) throws EmployeeException;

    /**
    *<p>
    * This method is gets the employee details of the corresponding id
    * in the database
    *
    * @param  employeeId object of the class Employee
    *
    * @throws EmployeeException
    *</p> 
    */
    Employee getEmployeeById(int employeeId) throws EmployeeException;

   /**
    *<p>
    * This method is removes the employee details of the corresponding id
    * in the database
    *
    * @param id- employeeId object of the class Employee
    *
    * @throws EmployeeException 
    *</p>
    */
    void deleteEmployee(int id) throws EmployeeException;

}