package com.Department.Service;

import java.util.List;
import java.util.Scanner;

import com.Department.DAO.DepartmentRepository;
import com.Employee.Service.EmployeeService;
import com.Model.Employee;
import com.Model.Department;
import com.customizedexception.EmployeeException;
/**
 *Class to implement interface for the employee Service
 *this interface provides methods for managing employee records.
 */
public interface DepartmentService{
   /**
    *Method implemented in serviceImpl for creating department records.
    *@param departmentName - name of the department to be added
    *@throws EmployeeException when there is an issue while adding a department
    */
    public void addDepartment(String departmentName) throws EmployeeException;

   /**
    *Method implemented in ServiceImpl for showing the department corresponding to the id.
    *@param departmentid - id of the department the employee is in
    *@throws employeeexception when theres an issue while displaying the deartment
    */
    public Department displayDepartment(int id) throws EmployeeException;

   /**
    *Method implemented in ServiceImpl for showing all the departments available.
    */
    public List<Department> displayAllDepartment() throws EmployeeException;

   /**
    *Method implemented in ServiceImpl for removing an department from the records.
    *@param id - unique identifier of the department
    *@throws employeeexception when cannot be deleted
    */
    public void removeDepartment(int id) throws EmployeeException;
   /**
    *Method implemented in ServiceImpl to check if the departmentid given by the employee
    *matches with the department id in the department.
    *@param id - unique identifier of the department
    *@throws EmployeeException while the id does cannot be fetched
    */
    public Department idChecker(int id) throws EmployeeException;

   /**
    *Method implemented in ServiceImpl to get show the user that the department 
    *has to be correctly given.
    */ 
    public boolean departmentCorrection();

   /**
    *Method implemented in ServiceImpl to get update the department details
    *that has been previously given given.
    *@param department - object of the class department
    *@throws EmployeeException when the department cannot be altered
    */ 
    public void alterDepartment(Department department) throws EmployeeException;

}   