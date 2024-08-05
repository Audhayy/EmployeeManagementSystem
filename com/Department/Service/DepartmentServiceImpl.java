package com.Department.Service;

import java.util.List;

import com.Department.DAO.DepartmentRepository;
import com.Employee.Service.EmployeeService;
import com.Model.Employee;
import com.Model.Department;
import com.customizedexception.EmployeeException;

   /**
    *This class acts as a Interface for the DepartmentServiceImpl.
    *the methods in the Service class is called for abstraction purpose
    */
    public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    private EmployeeService employeeService;

    public boolean departmentCorrection() {
       if(departmentRepository.checkDepartment()){
            return true;
       } else {
            return false;
       }
    }
    public void addDepartment(String departmentName) throws EmployeeException{
        departmentRepository.insertDepartment(departmentName);
    }

    public Department displayDepartment(int id) throws EmployeeException{
        return departmentRepository.getDepartmentById(id);
        
    }

    public List<Department> displayAllDepartment() throws EmployeeException{
      return departmentRepository.getAllDepartments();
       
    }

    public void alterDepartment(Department department) throws EmployeeException{
        departmentRepository.updateDepartment(department);
    }
    public void removeDepartment(int id) throws EmployeeException{
        departmentRepository.deleteDepartment(id);      
    }
    
    public Department idChecker(int id) throws EmployeeException {
        return departmentRepository.getDepartmentById(id);
    }

}


  