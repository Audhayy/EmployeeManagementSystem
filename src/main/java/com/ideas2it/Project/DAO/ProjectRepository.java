package com.ideas2it.Project.DAO;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import com.ideas2it.Model.Project;
import com.ideas2it.Model.Employee;

import com.ideas2it.customizedexception.EmployeeException;
import com.ideas2it.Connection.HibernateManager; 

/**This class acts as a Repository for performing data storage,retrieval and modifications.
 *ArrayList is the collection that is used here
 */
public class ProjectRepository {
   /**This method is used to insert project into  the database
    *@param name - name of the project employee is working in
    */    
    public void insertProject(String name)throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Project project = new Project(name);
            Integer id = (Integer) session.save(project);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while adding project of name : " + name, e);
        }

    }

   /**
    *Gets the project details from the id given by the user.
    *@param id - unique identifier of project.  
    */   
    public Project getProjectById(int id) throws EmployeeException {

        Transaction transaction = null;
        Project project = null;
        try (Session session = HibernateManager.getFactory().openSession()){
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
        }
        return project;

    }

   /**Gets all the project details  that are present in the database
    *@throws EmployeeException if the project details are null;
    */ 
    public List<Project> getAllProjects() throws EmployeeException {

        List<Project> projects = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateManager.getFactory().openSession()) {
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
        }
        return projects;
    } 

    /**Inserts an employee into projects 
    *@throws EmployeeException if the employee cannot be added into project.
    */    
    public void addEmployee(Employee employee, Project project) throws EmployeeException {
        Transaction transaction = null;
        Employee employeeObject;
        Project projectObject;
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            employeeObject = session.get(Employee.class, employee.getEmployeeId());
            projectObject = session.get(Project.class, project.getProjectId());
            Set<Project> projects = employeeObject.getProjectList();
            Set<Employee> employees = projectObject.getEmployees();
            projects.add(projectObject);
            employees.add(employeeObject);
            session.saveOrUpdate(projectObject);
            session.saveOrUpdate(employeeObject);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            throw new EmployeeException("Error while adding project " + project.getProjectName() + "to employee id : " + employee.getEmployeeName()
                    + e.getMessage(), e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  }
}