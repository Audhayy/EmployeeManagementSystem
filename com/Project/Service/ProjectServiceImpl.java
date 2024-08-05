package com.Project.Service;

import java.util.List;

import com.Project.DAO.ProjectRepository;
import com.Employee.Service.EmployeeService;
import com.Model.Employee;
import com.Model.Project;
import com.customizedexception.EmployeeException;


public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository = new ProjectRepository();
    private EmployeeService employeeService;

    public boolean projectCorrection() {
        if (projectRepository.checkProject()) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void addProject(String projectName) throws EmployeeException {
        projectRepository.insertProject(projectName);

    }
    @Override
    public Project displayProject(int id) throws EmployeeException{
        return projectRepository.getProjectById(id);
        
    }
    @Override
    public List<Project> displayAllProject() throws EmployeeException {
        return projectRepository.getAllProjects();
       
    }
    @Override
    public Project idChecker(int id) throws EmployeeException {
        return projectRepository.getProjectById(id);
    }
    @Override
    public List<Employee> showAllEmployee() throws EmployeeException {
        return employeeService.displayAllEmployee();
    }
    @Override
    public void employeeIntoProject(Employee employee, Project project) throws EmployeeException {
        projectRepository.addEmployee(employee, project);
    }
}


  