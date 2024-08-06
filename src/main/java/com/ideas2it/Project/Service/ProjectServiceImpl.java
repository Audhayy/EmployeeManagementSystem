package com.ideas2it.Project.Service;

import java.util.List;

import com.ideas2it.Project.DAO.ProjectRepository;
import com.ideas2it.Employee.Service.EmployeeService;
import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Project;
import com.ideas2it.customizedexception.EmployeeException;


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


  