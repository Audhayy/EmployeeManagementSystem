package com.ideas2it.Project.Controller;

import com.ideas2it.Project.Service.ProjectService;
import com.ideas2it.Project.Service.ProjectServiceImpl;
import com.ideas2it.Model.Employee;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Model.Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner; 
import java.util.List;
import java.util.ArrayList;

/**
*<p>
* This class is used to get the 
* choice of operation the user wants to perform.
*</p>
*/ 
public class ProjectController {
    ProjectService projectService = new ProjectServiceImpl();
    private static Logger logger = LogManager.getLogger();
    Scanner scanner = new Scanner(System.in);
    int id ;

    /**
     *<p>
     *Gets the Employee choice as string 
     *and performs corresponding operations in Project menu
     *It iterates till the flag breakout is true
     *</p>
     */
    public void projectChoice() {
    try {
        boolean bout = false;
        while(bout == false) {
            System.out.println("=====================================");            
            System.out.println("Please choose the appropriate option: ");
            System.out.println("=====================================");
            System.out.println("1) Enter new Project details:");
            System.out.println("2) Display specific Project details:");
            System.out.println("3) Display all records of Project details:");
            System.out.println("4) Display with employee Name:");
            System.out.println("5) Return to Employee menu:");

            System.out.println("=====================================");

                
            String choice = scanner.nextLine();  //user input stored in choice

            switch (choice) {
                case "1":
                    System.out.println("You chose the 'add dept' input");
                    addProject();
                    break;
                case "2": 
                    System.out.println("You chose to see specific Project details as");
                    displayProject();
                    break;
                case "3":   
                    System.out.println("You chose Display all Project details;"); 
                    for(Project project : projectService.displayAllProject()){
                    System.out.printf("|%-5s | %-10s |\n", "project: " + project.getProjectName(), 
                                       "ID:" +project.getProjectId());
                    }
                    break;
                case "4":
                    System.out.println("You chose to view employees in the Project:");
                    showEmployeesInProject();
                    break;
                case "5":
                    System.out.println("Back to main menu.");
                    bout= true;
                    break;

                default:
                    System.out.println("The input is not accurate");
                    break;
            }
        }
    }
    catch (EmployeeException e) {
	logger.error("Invalid Choice Enter Correct Choice..");
    }
}

    /**
     * <p>
     * Displays employee name in their respective Project.
     * </p>
     */
     public void showEmployeesInProject() {
         try{             
             System.out.println("enter Project ID:");
             id = scanner.nextInt();
             scanner.nextLine();
             List<Employee> employeeList = new ArrayList<>(projectService.idChecker(id).getEmployees());
             System.out.printf("employers in the project %d;\n",id);
             for(Employee employee :employeeList) {
                 System.out.println(employee.getEmployeeName());
             }
         } catch(EmployeeException e) {
             logger.error("an error occured while displaying employees in project.." + e.getMessage());
         } 
     }

     /**
     *<p>
     *insert project into the database
     *</p>
     */
     private void addProject() {
        try {
            scanner.nextLine();
            System.out.println("Enter the employee Project:");
            String projectName = scanner.nextLine();
            System.out.println("Enter the project ID:");
            int projectId = scanner.nextInt();
            scanner.nextLine();
            projectService.addProject(projectName);
            logger.info("project has been added of name" +projectName);
         } catch(EmployeeException e) {
                 logger.error("error occured while inserting a project" + e.getMessage());
         }
     }

   /**
    *<p>
    *This method is used to a specific project 
    *detail with respect to its id
    *</p>
    */
    public void displayProject() {
        try{
            System.out.print("Enter Project ID");
            id = scanner.nextInt();
            scanner.nextLine();
            Project project=projectService.displayProject(id);
            if(project!=null){
                System.out.println("project: " + project.getProjectName() +
                               "id: " +project.getProjectId());
            }
            else{
                logger.info("Project not Found");
            }
        } catch(EmployeeException e){
            logger.error("Could not display the project");
        }
     }

    /**
    *<p>
    *This method is used to a display all project 
    *</p>
    */
     public List<Project> viewAllProject() {
         try{
             return projectService.displayAllProject();
         } catch(EmployeeException e) {
             logger.error("cannot display all the project");
         }
	 return null;
     }  
}
  

