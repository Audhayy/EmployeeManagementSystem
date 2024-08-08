package com.ideas2it.Project.DAO;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD:com/Project/DAO/ProjectRepository.java
import java.util.Set;

import com.Model.Project;
import com.Model.Employee;
import com.customizedexception.EmployeeException;

import com.Connection.HibernateManager; 

/**
 *This class acts as a Repository for performing data storage,retrieval and modifications.
 *ArrayList is the collection that is used here
 */
public class ProjectRepository {
    private static final List<Project> projectList = new ArrayList<>();
    public boolean checkProject() {
        return projectList.isEmpty();
    }

   /**
    *This method is used to insert project into the database
=======

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
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Project/DAO/ProjectRepository.java
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
<<<<<<< HEAD:com/Project/DAO/ProjectRepository.java
    
   /**
    *Employees present in a project given by the user id
    *
    *@param projectId - the unique identifier of the project
    */      
    public List<Employee> getEmployeesByProject(int projectId) throws EmployeeException {
        Transaction transaction = null;
        List<Employee> employeeList = null;
        try (Session session = HibernateManager.getFactory().openSession()) {
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
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EmployeeException("Error while getting employees of project id : " + projectId, e);
        }
        return employeeList;
                    
    }
=======

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Project/DAO/ProjectRepository.java
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
<<<<<<< HEAD:com/Project/DAO/ProjectRepository.java
        } finally {
            if(null!= session) {
                session.close();
            }
=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Project/DAO/ProjectRepository.java
        }
        return project;

    }

   /**
    *Gets all the project details  that are present in the database
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

   /**
    *Inserts an employee into projects 
    *@throws EmployeeException if the employee cannot be added into project.
    */    
    public void addEmployee(Employee employee, Project project) throws EmployeeException {
        Transaction transaction = null;
<<<<<<< HEAD:com/Project/DAO/ProjectRepository.java
=======
        Employee employeeObject;
        Project projectObject;
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Project/DAO/ProjectRepository.java
        try (Session session = HibernateManager.getFactory().openSession()) {
            transaction = session.beginTransaction();
            employeeObject = session.get(Employee.class, employee.getEmployeeId());
            projectObject = session.get(Project.class, project.getProjectId());
            Set<Project> projects = employeeObject.getProjectList();
            Set<Employee> employees = projectObject.getEmployees();
            projects.add(projectObject);
            employees.add(employeeObject);
<<<<<<< HEAD:com/Project/DAO/ProjectRepository.java
            session.saveOrUpdate(employeeObject);
            session.saveOrUpdate(project);
=======
            session.saveOrUpdate(projectObject);
            session.saveOrUpdate(employeeObject);
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Project/DAO/ProjectRepository.java
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