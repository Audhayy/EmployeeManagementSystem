package com.ideas2it.Model;


import java.util.Set;


import javax.persistence.*;

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


