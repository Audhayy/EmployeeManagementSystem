package com.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import com.Model.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

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

    @ManyToMany(mappedBy = "projectList", fetch = FetchType.EAGER)
    
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


