package com.Employee.DAO;

import java.util.List;

import com.Model.Employee;
import com.customizedexception.EmployeeException;

/**
 *This interface has abstract methods for employeerepositoryimpl
 * @Author Audhithiyah 
 */
public interface EmployeeRepository {
  
    /**
     *<p>
     *This method is used to insert an employee detail into the database.
     *
     *@param employee - objectof the employee class
     *</p>
     */
    public void addEmployee(Employee employee) throws EmployeeException;

    /**
     *<p>
     *This method retrieves all the employees that are stored
     *in the database
     *
     *@return employeeRecords -list of employees present in the database
     *@throws EmployeeException- when all the employees cannot be retrieved
     *</p>
     */
     public List<Employee> getAllEmployees() throws EmployeeException;

   /**
    *<p>
    * This method is alters and changes the already stored data
    * in the database
    *
    * @param - Employee object of the class Employee
    *
    * @throws EmployeeException
    *</p> 
    */
    public void updateEmployee(Employee employee) throws EmployeeException;

    /**
    *<p>
    * This method is gets the employee details of the corresponding id
    * in the database
    *
    * @param - employeeId object of the class Employee
    *
    * @throws EmployeeException
    *</p> 
    */
    public Employee getEmployeeById(int employeeId) throws EmployeeException;

   /**
    *<p>
    * This method is removes the employee details of the corresponding id
    * in the database
    *
    * @param - employeeId object of the class Employee
    *
    * @throws EmployeeException 
    *</p>
    */
    public void deleteEmployee(int id) throws EmployeeException;

}