package com.Employee.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.customizedexception.EmployeeException;
import com.Department.Controller.DepartmentController;
import com.Department.Service.DepartmentService;
import com.Department.Service.DepartmentServiceImpl;
import com.Employee.Service.EmployeeService;
import com.Employee.Validator.EmployeeValidator;
import com.Employee.Service.EmployeeServiceImpl;
import com.Model.Department;
import com.Model.Employee;
import com.Model.Project;
import com.Project.Service.ProjectService;
import com.Project.Service.ProjectServiceImpl;
import com.Project.Controller.ProjectController;

/**
*<p>
* This class is where all the user interactions take place
*and contains the menu for CRUD operations.
*this class predominantly connects with service class.
*</p>
*/
public class EmployeeController {
    EmployeeService employeeService = new EmployeeServiceImpl();
    DepartmentController departmentController = new DepartmentController();
    DepartmentService departmentService = new DepartmentServiceImpl();
    ProjectController projectController = new ProjectController();
    ProjectService projectService = new ProjectServiceImpl();

    private static Logger logger = LogManager.getLogger();
    Scanner scanner = new Scanner(System.in);  

   /**
    *<p>
    *Gets the users choices and calls the service class to perform CRUD operations
    *</p>
    */
    public void employeeChoice() {
        boolean breakOut = false;
        while (breakOut == false) {
            System.out.println("===============Main Menu==================");            
            System.out.println("Please choose the appropriate option: ");
            System.out.println("=====================================");
            System.out.println("1) Enter new employee details:");
            System.out.println("2) Display specific Employee details:");
            System.out.println("3) Display all records of Employee details:");
            System.out.println("4) To Update an Employee details:");
            System.out.println("5) Delete an Employee Detail");
            System.out.println("6) Choose Department menu");
            System.out.println("7) Choose Project menu");
            System.out.println("8) include project in employee");
            System.out.println("9) Exit the program:");
            System.out.println("=====================================");    
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":   
                    System.out.println("You chose the 'add employee' input");
                    addEmployee();
                    break;            

                case "2": 
                   int id = 0;
                   try {
                       System.out.println("You chose to see a specific Employee details as");
                       System.out.print("Enter Employee ID");
                       id = scanner.nextInt();
                       scanner.nextLine();
                       Employee employee = employeeService.displayEmployee(id);
                       if (employee != null) {
                           System.out.printf("|%-5s |%-10s |%-15s |%-15s |%-20s |%-15s |%-15s|%-15s|%-15s\n",
                                             "ID" + employee.getEmployeeId() ,
                                             "Name: " + employee.getEmployeeName() ,
                                             "Dept ID" + employee.getDepartment().getDepartmentId() ,
                                             "Account ID" + employee.getPassport().getpassportNumber(),
                                             "Age: " + employee.getAge() , "Salary: " +
                                             employee.getEmployeeSalary() , "Phone Number: "+
                                             employee.getPhoneNumber() , "Email: " + 
                                             employee.getEmployeeEmail(),"projects" + employee.getProjectNames());
                       }
                       else {
                           logger.info("Employee not Found");
                       }
                   } catch(EmployeeException e) {
                        logger.error("Could not fetch the employee details" + id + e.getMessage());
                   }
                   break;

                case "3":   
                    System.out.println("You chose Display all employees;");
                    try {
                        List<Employee> employeeDetails = new ArrayList<>(employeeService.displayAllEmployee());
                        System.out.println(employeeDetails);
                        System.out.printf(("|%-5s |%-10s |%-15s |%-15s |%-10s |%-10s |%-15s | %-10s | %-20s |\n"), "ID", "Name",
                                          "Department Name", "PassportNumber", "CountryName", "Age",
                                          "Salary", "Phone Number", "Email", "Projects");
                        for (Employee employees : employeeService.displayAllEmployee()) {
                            System.out.println(employees);
                            System.out.printf(("|%-5s |%-10s |%-15s |%-10s | %-15s |%-10s |%-15s | %-10s| %-20s |\n"), employees.getEmployeeId(),
                                                employees.getEmployeeName(), employees.getDepartment().getDepartmentName(), 
                                                employees.getPassport().getpassportNumber(),
                                                employees.getPassport().getcountryName(),
                                                employees.getAge(),employees.getEmployeeSalary(), 
                                                employees.getPhoneNumber(), employees.getEmployeeEmail(), employees.getProjectNames());
                        }
                    } catch(EmployeeException e) {
                        logger.error("Could not fetch the employee details" + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
    
                case "4":
                    System.out.println("You chose to update Employee");
                    updateEmployee();
                    break;
                    
                case "5":
                    System.out.println("You chose to delete Employee");
                    System.out.println("Enter the Employee ID");
                    int Id =scanner.nextInt();
                    try {
                        employeeService.deleteEmployee(Id);
                    } catch(EmployeeException e) {
                        logger.error("could not delete the employee with the id.."+ Id + e.getMessage()); 
                    }
                    break;
                    
                case "6":
                    System.out.println("You chose department menu");
                    departmentController.departmentChoice();
                    break;
                    
                case "7":
                    System.out.println("You chose project menu");
                    projectController.projectChoice();
                    break;

                case "8":
                    System.out.println("You chose project to add an employee to a project");
                    try {
                        insertProjectToEmployee();
                        logger.info("project has been succesfully assigned to the employee");
                    } catch(Exception e) {
                        logger.error("could not insert project to employee.." + e.getMessage()); 
                    }
                    break;
                     
                case "9":
                    System.out.println("You chose to Exit.");
                    breakOut= true;
                    break;
                   
                default:
                    System.out.println("input is not accurate");
                    break;
            }
        }
    }
  
    /**
     *<p>
     *This method gets user input that is to be stored
     *and calls to check the validity by matching constraints
     *</p>
     */  
    private void addEmployee() {
        try {
            System.out.println("Please enter your Full name:");
            String name = scanner.nextLine();
            logger.debug("Employee credentials validation has been initiated");
            if (!EmployeeValidator.isValidUsername(name)) {
                System.out.println("Invalid Username");
                return;
            }
            System.out.println("Please enter your Date of Birth(yyyy-mm-dd):");
            LocalDate DOB = LocalDate.parse(scanner.nextLine());
            for(Department department : departmentService.displayAllDepartment()) {
                System.out.printf("|%-5s | %-10s |\n", "Department: " + department.getDepartmentName(), 
                              "ID:" +department.getDepartmentId());
            }
            System.out.println("Please enter your Department ID from the above table:");
            int departmentId = scanner.nextInt();
     	    Department department = departmentService.idChecker(departmentId);
            System.out.println("Please enter your Salary:");
            int salary= scanner.nextInt();
            System.out.println("Please enter your email Address:");
            scanner.nextLine();
            String emailAddress = scanner.nextLine();
            if (!EmployeeValidator.isValidEmail(emailAddress)) {
                System.out.println("Invalid Email Adress please check");
                return;
            }
            System.out.println("Please enter your Phone number");
            String phoneNum = scanner.nextLine();
            if (!EmployeeValidator.isValidPhoneNumber(phoneNum)) {
                System.out.println("Invalid Phone Number please check");
                return;
            }
            System.out.println("Please enter your Passport Number");
            int passportNumber = scanner.nextInt();
            System.out.println("Please enter your country Name");
            scanner.nextLine();
            String countryName = scanner.nextLine();
            logger.debug("Employee credentials validation has been terminated");

            try {
                employeeService.addEmployee(name, DOB, departmentId, salary,
                           emailAddress, phoneNum, department, passportNumber, countryName);
                logger.info(name + " has been added successfully");
	    } catch (EmployeeException e) {
		logger.error("Error while Adding Employee.." + e.getMessage());
	    }
        } catch (Exception e) {
             logger.error("Error: The employee list is not initialized." + e.getMessage());
        }
    }
        
    /**
     *<p>
     *This method gets user id that is to be updated
     *and reassigns the data fields
     *</p>
     */
    public void updateEmployee() { 
        try {  
            System.out.println("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Employee employee=employeeService.displayEmployee(id);
            if(employee!=null) {
                System.out.println("Enter new name: ");
                employee.setEmployeeName(scanner.nextLine());

                System.out.println("Enter new DOB(yyyy-mm-dd: ");
                employee.setEmployeeDOB(LocalDate.parse(scanner.nextLine()));

                System.out.println("Enter new Email Address ");
                employee.setEmployeeEmail(scanner.nextLine());

                System.out.println("Enter new Phone number: ");
                employee.setPhoneNumber(scanner.nextLine());
           
                System.out.println("Enter new Salary: ");
                employee.setEmployeeSalary(scanner.nextInt());
                employeeService.updateEmployee(employee);
                logger.info(id +"employee of this id has been updated successfully");
            } else {
                logger.info("ID not found");
            }
        } catch (EmployeeException e) {
            logger.error("Error: The employee list is unmodified." + e.getMessage());
        }
    }

   /**
    *<p>
    *This method is used to add
    *project details to employee
    *</p>
    */
    public void insertProjectToEmployee() {
        try {
            System.out.println("Enter Employee Id: ");
            int employeeId = scanner.nextInt();
            System.out.print("Enter project Id: ");
            int projectId = scanner.nextInt();
            scanner.nextLine();
            Employee employee = employeeService.displayEmployee(employeeId);
            Project project = projectService.displayProject(projectId);
            employeeService.insertToEmployee(employee, project);
            logger.info("project added to employee successfully.");
        } catch (EmployeeException e) {
            logger.error("unable to add this project for employee" + e.getMessage());
        }
    }
       

}