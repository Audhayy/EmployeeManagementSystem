package com.Project.Service;

import java.util.List;

import com.Model.Employee;
import com.Model.Project;
import com.customizedexception.EmployeeException;



public interface ProjectService{

    /**
    *<p>
    *Method implemented in ServiceImpl to get show the user that the project 
    *has to be correctly given.
    *</p>
    */ 
     boolean projectCorrection();
  
    /**
    *<p>
    *Method implemented in serviceImpl for creating department records.
    *@throws EmployeeException when there is an issue while adding 
    *</p>
    */
    void addProject(String projectName) throws EmployeeException;

    /**
    *<p>
    *This method is used to show project details corresponding 
    *to the id given by the user
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */  
    Project displayProject(int id) throws EmployeeException;

    /**
    *<p>
    *This method is used to show project details
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    List<Project> displayAllProject() throws EmployeeException ;

    /**
    *<p>
    *This method is used to see if the id provided is present  
    *in the database
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    Project idChecker(int id) throws EmployeeException;
    /**
    *This method is used to show employees present in a project
    *@throws EmployeeException throws exception when it is unable to show employee
    */
    List<Employee> showAllEmployee() throws EmployeeException;
   
    /**
    *<p>
    *This method is used to add project details corresponding 
    *to the id given by the user
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    void employeeIntoProject(Employee employee, Project project) throws EmployeeException;

}