package com.ideas2it.Project.Service;

import java.util.List;
import java.util.Scanner;

import com.ideas2it.Project.DAO.ProjectRepository;
import com.ideas2it.Employee.Service.EmployeeService;
import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Project;
import com.ideas2it.customizedexception.EmployeeException;



public interface ProjectService{

    /**
    *<p>
    *Method implemented in ServiceImpl to get show the user that the project 
    *has to be correctly given.
    *</p>
    */ 
    public boolean projectCorrection();
  
    /**
    *<p>
    *Method implemented in serviceImpl for creating department records.
    *@param departmentName - name of the department to be added
    *@throws EmployeeException when there is an issue while adding 
    *</p>
    */
    public void addProject(String projectName) throws EmployeeException;

    /**
    *<p>
    *This method is used to show project details corresponding 
    *to the id given by the user
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */  
    public Project displayProject(int id) throws EmployeeException;

    /**
    *<p>
    *This method is used to show project details
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    public List<Project> displayAllProject() throws EmployeeException ;

    /**
    *<p>
    *This method is used to see if the id provided is present  
    *in the database
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    public Project idChecker(int id) throws EmployeeException;
    /**
    *This method is used to show employees present in a project
    *@throws EmployeeException throws exception when it is unable to show employee
    */
    public List<Employee> showAllEmployee() throws EmployeeException;
   
    /**
    *<p>
    *This method is used to add project details corresponding 
    *to the id given by the user
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    *</p>
    */
    public void employeeIntoProject(Employee employee, Project project) throws EmployeeException;

}