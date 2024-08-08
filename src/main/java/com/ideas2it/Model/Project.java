package com.ideas2it.Model;


<<<<<<< HEAD:com/Model/Project.java

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
=======
import java.util.Set;


import javax.persistence.*;
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Model/Project.java

/**
 *<p>
 *This is a class created to associate with employee and 
 *projects and has data members like project name,project id.
 *
 *@author Audhithiyah
 *</p>
 */
@Entity
@Table(name = "project") 
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "id")
    private int projectId;

    @Column(name ="name")
    private String projectName;

    @ManyToMany(mappedBy = "projectList",
            fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Project() {}
	
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Project(int projectId, String projectName) {
        this.projectName = projectName;
        this.projectId = projectId;
     }

    public Project(String projectName) {
	this.projectName = projectName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}


