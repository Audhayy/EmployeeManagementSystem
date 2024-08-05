package com.Employee.Service;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

import com.Model.Department;
import com.Model.Employee;
import com.Employee.DAO.EmployeeRepository;
import com.Employee.DAO.EmployeeRepositoryImpl;
import com.Model.Project;
import com.Project.Service.ProjectService;
import com.Project.Service.ProjectServiceImpl;
import com.Department.Service.DepartmentService;
import com.Department.Service.DepartmentServiceImpl;
import com.customizedexception.EmployeeException;
import com.Model.Passport;
import com.passport.service.PassportService;
import com.passport.service.PassportServiceImpl;

public class EmployeeServiceImpl implements EmployeeService { 
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    PassportService passportService = new PassportServiceImpl();
    DepartmentService departmentService = new DepartmentServiceImpl();
    ProjectService projectService = new ProjectServiceImpl();
    private Scanner scanner= new Scanner(System.in);
   
    @Override
    public void addEmployee(String name, LocalDate DOB, int departmentId,
                            int Salary,String EmailAddress,
                            String PhoneNumber, Department department, int passportNumber, String countryName) throws EmployeeException { 
        try {
            Passport passport = new Passport(passportNumber, countryName);
            passportService.addPassport(passport);
            Employee employee = new Employee(name,DOB, Salary, EmailAddress, PhoneNumber,department, passport);                                                          
            employeeRepository.addEmployee(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Null can't be added ");
            throw new EmployeeException("Employee cannot be inserted with the name.." + name,e);
        }
    }
    
    @Override
    public Employee displayEmployee(int id) throws EmployeeException {
        try {
            if(employeeRepository.getEmployeeById(id).getsoftDelete()==false) {
                return employeeRepository.getEmployeeById(id);
            }
        } catch (Exception e) {
              throw new EmployeeException("Employee cannot be displayed"+id,e);
       } return null; 
    }

    @Override
    public List<Employee> displayAllEmployee() throws EmployeeException {
       try{
           return employeeRepository.getAllEmployees();
       } catch(Exception e) { 
               throw new EmployeeException("Employee cannot be displayed",e);
       }
    }

    @Override
    public void updateEmployee(Employee employee) throws EmployeeException {
        try {
           employeeRepository.updateEmployee(employee);
        } catch (Exception e) {
           throw new EmployeeException("Employees cannot be updated",e);
        }

    }      
   
    @Override
    public void deleteEmployee(int id) throws EmployeeException{
        try {
            Employee employee = employeeRepository.getEmployeeById(id);
            if(employee!=null)
            {
                employee.setsoftDelete(false);
            }
        } catch(Exception e) {
                throw new EmployeeException("Employee cannot be deleted for the id.."+ id, e);
        }     
    }

    @Override
    public void insertToEmployee(Employee employee, Project project) throws EmployeeException {
        projectService.employeeIntoProject(employee, project);
    }  
    
    @Override
    public Department getDepartmentById(int departmentId) throws EmployeeException {
        return departmentService.displayDepartment(departmentId);
    }
}
