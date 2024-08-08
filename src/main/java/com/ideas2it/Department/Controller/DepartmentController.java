package com.ideas2it.Department.Controller;

import com.ideas2it.Department.Service.DepartmentService;
import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Department;
import com.ideas2it.Department.Service.DepartmentServiceImpl;
import com.ideas2it.customizedexception.EmployeeException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner; 
import java.util.List;
import java.util.ArrayList;

public class DepartmentController {
    DepartmentService departmentService = new DepartmentServiceImpl();
    private static final Logger logger = LogManager.getLogger();
    Scanner scanner = new Scanner(System.in);
    

   /**
    *Gets the Employee choice as string 
    *and performs corresponding operations in department menu
    *It iterates till the flag breakout is true
    */
    public void departmentChoice() {
        boolean bout = false;
        while(!bout) {
            System.out.println("=====================================");            
            System.out.println("Please choose the appropriate option: ");
            System.out.println("=====================================");
            System.out.println("1) Enter new Department details:");
            System.out.println("2) Display specific Department details:");
            System.out.println("3) Display all records of Department details:");
            System.out.println("4) To Update an Department details:");
            System.out.println("5) Delete an Department Detail");
            System.out.println("6) Display with employee Name:");
            System.out.println("7) Return to Employee menu:");

            System.out.println("=====================================");
            String choice = scanner.nextLine();  //user input stored in choice
            switch (choice) {
                case "1":
                    System.out.println("You chose the 'add department' input");
                    addDepartment();
                    break;
                case "2": 
                    System.out.println("You chose to see specific department details as");
                    displayDepartment();
                    break;
                case "3":   
                    viewAllDepartment();
                    break;
                case "4":
                    int id = 0;
                    try{
                        System.out.println("You chose to update Department details");
                        System.out.println("Enter Department ID to update: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new dept name: ");
                        String departmentName = scanner.nextLine();
                        Department department = new Department(departmentName, id);
                        departmentService.alterDepartment(department);
                        logger.info("Department Updated of name: {}", departmentName);
                        } catch(EmployeeException e) {
                        logger.error("Could not update the employee details{}", e.getMessage());
                    }
                    break;
                     
                case "5":
                    id = 0;
                    try{
                        System.out.println("You chose to Delete Department details");
                        System.out.println("Enter the dept ID");
                        id =scanner.nextInt();
                        departmentService.removeDepartment(id);
                    } catch(EmployeeException e) {
                        logger.info("Unable to remove department{}{}", id, e.getMessage());
                    }
                    break;
                case "6":
                    System.out.println("You chose to view employees in the department:");
                    showEmployeesInDepartment();
                    break;
                case "7":
                    System.out.println("Back to main menu.");
                    bout= true;
                    break;

                default:
                    System.out.println("The input is not accurate");
                    break;
            }
        }
    }

   /**
    *This method is used to display employee name
    *in their respective department
    */
    public void showEmployeesInDepartment() {
        int id = 0;
        try {             
            System.out.println("enter Department ID:");
            id = scanner.nextInt();
            scanner.nextLine();
            Department department = departmentService.idChecker(id);
            List<Employee> employeeRecords = new ArrayList<>(department.getEmployees());
            System.out.printf("employers in the department %d;\n",id);
            for(Employee employee : employeeRecords) {
                System.out.println(employee.getEmployeeName());
            }
        } catch(EmployeeException e){
            logger.error("unable to show employees in department:{}", e.getMessage());
        } 
    }

     private void addDepartment() {
         try {
             scanner.nextLine();
             System.out.println("Enter the employee Department:");
             String departmentName = scanner.nextLine();
             departmentService.addDepartment(departmentName);
<<<<<<< HEAD:com/Department/Controller/DepartmentController.java
             logger.info("department has been added successfully of name{}", departmentName);
=======
             logger.info("department has been added sucesssfully of name{}", departmentName);
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/Controller/DepartmentController.java
         } catch (EmployeeException e) {
             logger.error(e.getMessage());
         }
     }

   /**
    *This method is used to a specific department 
    *detail with respect to its id
    */
    public void displayDepartment() {
        int id = 0;
        try{
            System.out.print("Enter Department ID");
            id = scanner.nextInt();
            scanner.nextLine();
            Department department=departmentService.displayDepartment(id);
            if(department!=null){
                System.out.println("Department: " + department.getDepartmentName() 
                                    +"id: " +department.getDepartmentId());
            }
            else{
                logger.info("Department not Found");
            }
        } catch(EmployeeException e) {
            logger.error("unable to show department:{}", e.getMessage());
        }
         
    }

   /*This method is used to display all the department that are present
    *in the database
    */
    public void viewAllDepartment() {
         try {
             System.out.println("You chose Display all department details;"); 
             for(Department department : departmentService.displayAllDepartment()) {
                 System.out.printf("|%-5s | %-10s |\n", "Department: " + department.getDepartmentName(), 
                                   "ID:" +department.getDepartmentId());
             }
         } catch(EmployeeException e) {
             logger.error("Could not fetch the department details{}", e.getMessage());
         }
     }
}  


