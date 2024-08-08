package com.ideas2it.Model;


<<<<<<< HEAD:com/Model/Department.java

=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Model/Department.java
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.Table;
<<<<<<< HEAD:com/Model/Department.java
import javax.persistence.OneToMany;
=======

import javax.persistence.OneToMany;

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Model/Department.java
/**
  *<p>
  *This is a class created to associate with employee and 
  *and has data members like department name,department id.
  *
  *@author Audhithiyah
  *</p>
  */

@Entity
@Table(name = "department") 
public class Department {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "department_id")
    private int departmentId;

    @Column(name ="department_name")
    private String departmentName;
  
    @OneToMany(mappedBy ="department", fetch = FetchType.EAGER)
    
    private Set<Employee> employees;
    
    public Department() {}

    public Department(String departmentName,int departmentId) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
	
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
       this.departmentId = departmentId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}


