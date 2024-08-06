package com.ideas2it.Project.DAO;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.ideas2it.Model.Project;
import com.ideas2it.Model.Employee;
import com.ideas2it.Model.Department;
import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Connection.DatabaseConnection;
import com.ideas2it.Connection.HibernateManager; 

/**This class acts as a Repository for performing data storage,retrival and modifications.
 *ArrayList is the collection that is used here
 */
public class ProjectRepository {
    private static List<Project> projectList = new ArrayList<>();
    public boolean checkProject() { 
        if(! projectList.isEmpty()) {
            return false;
        }
        else
        return true;
    }

   /**This method is used to insert project into the the database
    *@param name - name of the project employee is working in
    */    
    public void insertProject(String name)throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Project project = new Project(name);
            Integer id = (Integer) session.save(project);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while adding project of name : " + name ,e);
        } finally {
            session.close();
        }

    }
    
   /**
    *Employees present in a project given by the user id
    *
    *@param projectid - the unique identifier of the project
    */      
    public List<Employee> getEmployeesByProject(int projectId) throws EmployeeException {
        List<Employee> employeeList = null;
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "select project from Project project left join fetch project.employees where project.id = :projectId";
            Project project = session.createQuery(hql, Project.class)
                                              .setParameter("id", projectId)
                                              .uniqueResult();
            if (project != null) {
                Hibernate.initialize(project.getEmployees());
                employeeList = new ArrayList<>(project.getEmployees());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while getting employees of project id : " + projectId ,e);
        } finally {
            session.close();
        }
        return employeeList;
                    
    }
   /**
    *Gets the project details from the id given by the user.
    *@param id - unique identifier of project.  
    */   
    public Project getProjectById(int id) throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        Project project = null;
        try {
            transaction = session.beginTransaction();
            Query<Project> query = session.createQuery("from Project where id = :id", Project.class);
            query.setParameter("id", id);
            project = query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while get Project with id : " + id,e);
        } finally {
            session.close();
        }
        return project;

    }

   /**Gets all the project details  that are present in the database
    *@throws EmployeeException if the project details are null;
    */ 
    public List<Project> getAllProjects() throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        List<Project> projects = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Project> query = session.createQuery("from Project", Project.class);
            List<Project> projectsFromDataBase = query.list();
            for (Project project : projectsFromDataBase) {
                projects.add(project);
            }
            transaction.commit();     
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while fetching available projects !",e);
        } finally {
            session.close();
        }
        return projects;
    } 

    /**Inserts an employee into projects 
    *@throws EmployeeException if the employee cannot be added into project.
    */    
    public void addEmployee(Employee employee, Project project) throws EmployeeException {
        Session session = HibernateManager.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employeeObject = session.get(Employee.class, employee.getEmployeeId());
            project = session.get(Project.class, project.getProjectId());
            Set<Project> projects = employee.getProjectList();
            Set<Employee> employees = project.getEmployees();
            projects.add(project);
            employees.add(employeeObject);
            session.saveOrUpdate(employeeObject);    
            session.saveOrUpdate(project);  
            transaction.commit();          
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            throw new EmployeeException("Error while adding project " + project.getProjectName() + "to employee id : " + employee.getEmployeeName() 
                                         + e.getMessage(), e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
  }
}