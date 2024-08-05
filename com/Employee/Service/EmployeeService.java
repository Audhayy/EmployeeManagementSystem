package com.Employee.Service;

import com.Employee.Service.EmployeeServiceImpl;
import com.Model.Employee;
import com.Model.Department;
import com.Model.Project;
import com.Employee.DAO.EmployeeRepository;
import com.Project.Service.ProjectService;
import com.Department.Service.DepartmentService;
import com.customizedexception.EmployeeException;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**This class acts as a Interface for the EmployeeServiceImpl.
 *the methods in the Service class is called for abstraction purpose
 */
public interface EmployeeService{
   /**
    * Insert new employee details into the array list
    *
    * @param name - gets the employee name from the user.
    * @param EmployeeID - assigns a ID for a user.
    * @param DOB - gets the age of the employee from the user.
    * @param DepartmentID - gets the deapartment ID in which the employee is working.
    * @param Salary - gets the salary of the employee from the user. 
    * @param EmailAddress - gets the email address of the employee from the user.
    * @param PhoneNumber - gets the phone number of the employee from the user.
    * @param department - gets the employee name from the user.

    * @throws EmployeeException if an employee with that id is not found.
    */
    public void addEmployee(String name, LocalDate DOB, int departmentId,
                            int Salary,String EmailAddress,
                            String PhoneNumber, Department department, int passportNumber, String countryName) throws EmployeeException;
   /**
    * Show the employee present corresponding to the id.
    *
    * @param employeeId- The unique identifier of the employee.
    * @throws EmployeeException if an employee with that id is not found.
    */
    public Employee displayEmployee(int id) throws EmployeeException;
    
   /**
    * To view all the employees that is stored in the the database .
    *
    * @throws EmployeeException if there are no employees in the array list.
    */
    public List<Employee> displayAllEmployee() throws EmployeeException;  
  
   /**
    * update existing details for an employee.
    *
    * @param employee - object of class Employee.
    * @throws EmployeeException if the employees cannot get altered. 
    */
    public void updateEmployee(Employee employee) throws EmployeeException;

   /**
    *With the given id by the user fetch that id from the department 
    *DAO and display the department details to the user
    *
    *@param departmentId -The unique identifier of an department
    *@throws EmployeeException if the id is not present  
    */
    public Department getDepartmentById(int departmentId) throws EmployeeException;
    
   /**
    *This method softdeletes the employee details present in
    *the database
    *@param id - unique identifier of the employee.
    */
    public void deleteEmployee(int id) throws EmployeeException;

   /*This method adds an employee to the project database
    *@param employee - object of the employee class
    *@param project - object of the project class
    *
    *@throws employeeexception is called when it cant be inserted.
    */
    public void insertToEmployee(Employee employee, Project project) throws EmployeeException;
}