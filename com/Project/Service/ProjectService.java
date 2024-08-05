package com.Project.Service;

import java.util.List;
import java.util.Scanner;

import com.Project.DAO.ProjectRepository;
import com.Employee.Service.EmployeeService;
import com.Model.Employee;
import com.Model.Project;
import com.customizedexception.EmployeeException;



public interface ProjectService{

    /**
    *Method implemented in ServiceImpl to get show the user that the project 
    *has to be correctly given.
    */ 
    public boolean projectCorrection();
  
    /**
    *Method implemented in serviceImpl for creating department records.
    *@param departmentName - name of the department to be added
    *@throws EmployeeException when there is an issue while adding 
    */
    public void addProject(String projectName) throws EmployeeException;

    /**
    *This method is used to show project details corresponding 
    *to the id given by the user
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    */  
    public Project displayProject(int id) throws EmployeeException;

    /**
    *This method is used to show project details
    *@throws EmployeeException throws exception when it is unable to show employee
    */
    public List<Project> displayAllProject() throws EmployeeException ;

    /**
    *This method is used to see if the id provided is present  
    *in the database
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    */
    public Project idChecker(int id) throws EmployeeException;
    /**
    *This method is used to show employees present in a project
    *@throws EmployeeException throws exception when it is unable to show employee
    */
    public List<Employee> showAllEmployee() throws EmployeeException;
   
    /**
    *This method is used to add project details corresponding 
    *to the id given by the user
    *@param id - unique identifier of the project
    *@throws EmployeeException throws exception when it is unable to show employee
    */
    public void employeeIntoProject(Employee employee, Project project) throws EmployeeException;

}