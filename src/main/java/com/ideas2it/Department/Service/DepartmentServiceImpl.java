package com.ideas2it.Department.Service;

import java.util.List;

<<<<<<< HEAD:com/Department/Service/DepartmentServiceImpl.java
import com.Department.DAO.DepartmentRepository;
import com.Employee.Service.EmployeeService;
import com.Model.Department;
import com.customizedexception.EmployeeException;
=======
import com.ideas2it.Department.DAO.DepartmentRepository;
import com.ideas2it.Employee.Service.EmployeeService;
import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Department;
import com.ideas2it.customizedexception.EmployeeException;
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/Service/DepartmentServiceImpl.java

   /**
    *<p>
    *This class acts as a Interface for the DepartmentServiceImpl.
    *the methods in the Service class is called for abstraction purpose
    *</p>
    */
    public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository = new DepartmentRepository();
    private EmployeeService employeeService;

<<<<<<< HEAD:com/Department/Service/DepartmentServiceImpl.java
    public boolean departmentCorrection() {
        return departmentRepository.checkDepartment();
    }
=======

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Department/Service/DepartmentServiceImpl.java
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


  