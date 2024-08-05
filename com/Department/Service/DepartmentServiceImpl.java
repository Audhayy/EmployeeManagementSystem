package com.Department.Service;

import java.util.List;

import com.Department.DAO.DepartmentRepository;
import com.Employee.Service.EmployeeService;
import com.Model.Employee;
import com.Model.Department;
import com.customizedexception.EmployeeException;

   /**
    *<p>
    *This class acts as a Interface for the DepartmentServiceImpl.
    *the methods in the Service class is called for abstraction purpose
    *</p>
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
    @Override
    public void addDepartment(String departmentName) throws EmployeeException{
        departmentRepository.insertDepartment(departmentName);
    }
    @Override
    public Department displayDepartment(int id) throws EmployeeException{
        return departmentRepository.getDepartmentById(id);
        
    }
    @Override
    public List<Department> displayAllDepartment() throws EmployeeException{
      return departmentRepository.getAllDepartments();   
    }
    @Override
    public void alterDepartment(Department department) throws EmployeeException{
        departmentRepository.updateDepartment(department);
    }
    @Override
    public void removeDepartment(int id) throws EmployeeException{
        departmentRepository.deleteDepartment(id);      
    }
    @Override
    public Department idChecker(int id) throws EmployeeException {
        return departmentRepository.getDepartmentById(id);
    }

}


  