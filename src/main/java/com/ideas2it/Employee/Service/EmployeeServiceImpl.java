package com.ideas2it.Employee.Service;

import java.util.List;
import java.time.LocalDate;

import com.ideas2it.Model.Department;
import com.ideas2it.Model.Employee;
import com.ideas2it.Employee.DAO.EmployeeRepository;
import com.ideas2it.Employee.DAO.EmployeeRepositoryImpl;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Model.Passport;
import com.ideas2it.passport.service.PassportService;
import com.ideas2it.passport.service.PassportServiceImpl;

public class EmployeeServiceImpl implements EmployeeService { 
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    PassportService passportService = new PassportServiceImpl();
<<<<<<< HEAD:com/Employee/Service/EmployeeServiceImpl.java
    DepartmentService departmentService = new DepartmentServiceImpl();
    ProjectService projectService = new ProjectServiceImpl();

=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Employee/Service/EmployeeServiceImpl.java
   
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
            if(!employeeRepository.getEmployeeById(id).getsoftDelete()) {
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


    

}
