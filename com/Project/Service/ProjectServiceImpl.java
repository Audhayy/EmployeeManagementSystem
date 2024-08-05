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
    public void addProject(String projectName) throws EmployeeException {
        projectRepository.insertProject(projectName);

    }
    public Project displayProject(int id) throws EmployeeException{
        return projectRepository.getProjectById(id);
        
    }
    public List<Project> displayAllProject() throws EmployeeException {
        return projectRepository.getAllProjects();
       
    }
    public Project idChecker(int id) throws EmployeeException {
        return projectRepository.getProjectById(id);
    }

    public List<Employee> showAllEmployee() throws EmployeeException {
        return employeeService.displayAllEmployee();
    }

    public void employeeIntoProject(Employee employee, Project project) throws EmployeeException {
        projectRepository.addEmployee(employee, project);
    }
}


  