package com.ideas2it.Employee.Service;

<<<<<<< HEAD:com/Employee/Service/EmployeeService.java
import com.Model.Employee;
import com.Model.Department;
import com.Model.Project;
import com.customizedexception.EmployeeException;

=======

import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Department;

import com.ideas2it.customizedexception.EmployeeException;

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/Service/EmployeeService.java
import java.util.List;
import java.time.LocalDate;

/**<p>This class acts as Interface for the EmployeeServiceImpl.
 *the methods in the Service class is called for abstraction purpose.
 * @author Audhithiyah
 *</p>
 */
public interface EmployeeService{
   /**
    *<p>
    * Insert new employee details into the array list
    *
    * @param name - gets the employee name from the user.
    * @param DOB - gets the age of the employee from the user.
    * @param departmentId - gets the department ID in which the employee is working.
    * @param Salary - gets the salary of the employee from the user. 
    * @param EmailAddress - gets the email address of the employee from the user.
    * @param PhoneNumber - gets the phone number of the employee from the user.
    * @param department - gets the employee name from the user.

    * @throws EmployeeException if an employee with that id is not found.
    *</p>
    */
<<<<<<< HEAD:com/Employee/Service/EmployeeService.java
   void addEmployee(String name, LocalDate DOB, int departmentId,
=======
    void addEmployee(String name, LocalDate DOB, int departmentId,
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/Service/EmployeeService.java
                            int Salary,String EmailAddress,
                            String PhoneNumber, Department department, int passportNumber, String countryName) throws EmployeeException;
   /**
    *<p>
    * Show the employee present corresponding to the id.
    *
    * @param id- The unique identifier of the employee.
    * @return Employee -object of class Employee
    *
    * @throws EmployeeException if an employee with that id is not found.
    *</p>
    */
    Employee displayEmployee(int id) throws EmployeeException;
    
   /**
    *<p>
    * To view all the employees that is stored in the the database.
    *
    * @return list of employees present in the database
    *
    * @throws EmployeeException if there are no employees in the array list.
    *</p>
    */
    List<Employee> displayAllEmployee() throws EmployeeException;
  
   /**
    *<p>
    * update existing details for an employee
    *
    * @param employee - object of class Employee.
    *
    * @throws EmployeeException if the employees cannot get altered. 
    *</p>
    */
    void updateEmployee(Employee employee) throws EmployeeException;
<<<<<<< HEAD:com/Employee/Service/EmployeeService.java

   /**
    *<p>
    *With the given id by the user fetch that id from the department 
    *DAO and display the department details to the user
    *
    *@param departmentId -The unique identifier of a department
    *@return department - object of class Department
    *
    *@throws EmployeeException if the id is not present.
    *</p>
    */
    Department getDepartmentById(int departmentId) throws EmployeeException;
=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/Service/EmployeeService.java
    
   /**
    *<p>
    *This method softdeletes the employee details present in
    *the database
    *
    *@param id - unique identifier of the employee.
    *
    *@throws EmployeeException if there is an issue while deleting the detail
    *</p>
    */
<<<<<<< HEAD:com/Employee/Service/EmployeeService.java
     void deleteEmployee(int id) throws EmployeeException;
=======
    void deleteEmployee(int id) throws EmployeeException;
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/Service/EmployeeService.java

   /**
    *<p>
    *This method adds an employee to the project database
    *
    *@param employee - object of the employee class
    *@param project - object of the project class
    *
    *@throws EmployeeException is called when it cant be inserted.
    *</p>
    */
<<<<<<< HEAD:com/Employee/Service/EmployeeService.java
    void insertToEmployee(Employee employee, Project project) throws EmployeeException;
=======

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/Service/EmployeeService.java
}