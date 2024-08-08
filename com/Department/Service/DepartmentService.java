package com.Department.Service;

import java.util.List;

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
   void addDepartment(String departmentName) throws EmployeeException;

   /**
    *Method implemented in ServiceImpl for showing the department corresponding to the id.
    *@param id - id of the department the employee is in
    *@throws EmployeeException when there is an issue while displaying the department
    */
    Department displayDepartment(int id) throws EmployeeException;

   /**
    *Method implemented in ServiceImpl for showing all the departments available.
    */
    List<Department> displayAllDepartment() throws EmployeeException;

   /**
    *Method implemented in ServiceImpl for removing a department from the records.
    *@param id - unique identifier of the department
    *@throws EmployeeException when cannot be deleted
    */
    void removeDepartment(int id) throws EmployeeException;
   /**
    *Method implemented in ServiceImpl to check if the department id given by the employee
    *matches with the department id in the department.
    *@param id - unique identifier of the department
    *@throws EmployeeException while the id does cannot be fetched
    */
    Department idChecker(int id) throws EmployeeException;

   /**
    *Method implemented in ServiceImpl to get show the user that the department 
    *has to be correctly given.
    */ 
    boolean departmentCorrection();

   /**
    *Method implemented in ServiceImpl to get update the department details
    *that has been previously given.
    *@param department - object of the class department
    *@throws EmployeeException when the department cannot be altered
    */ 
    void alterDepartment(Department department) throws EmployeeException;

}   