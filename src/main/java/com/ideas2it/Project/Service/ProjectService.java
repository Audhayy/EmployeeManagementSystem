package com.ideas2it.Project.Service;

import java.util.List;

import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Project;
import com.ideas2it.customizedexception.EmployeeException;



public interface ProjectService{

    /**
    *<p>
    *Method implemented in serviceImpl for creating department records.
    *@param projectName - name of the department to be added
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
    *<p>
    *This method is used to add project details corresponding 
    *to the id given by the user
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    void employeeIntoProject(Employee employee, Project project) throws EmployeeException;

}