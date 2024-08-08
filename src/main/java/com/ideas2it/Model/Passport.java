package com.ideas2it.Model;


<<<<<<< HEAD:com/Model/Passport.java

=======
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Model/Passport.java

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD:com/Model/Passport.java
import javax.persistence.Table;
=======

import javax.persistence.Table;

>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Model/Passport.java
/**
  *This is a class created to associate with employee
  *and has data members like passport name,passport id.
  *
  *@author Audhithiyah
  */

@Entity
@Table(name = "passport") 
public class Passport {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;

    @Column(name = "passport_number")
    private int passportNumber;

    @Column(name ="country_name")
    private String countryName;

    public Passport() {}

    public Passport(int passportNumber,String countryName) {
        this.passportNumber = passportNumber;
        this.countryName = countryName;
    }
	
    public String getcountryName() {
        return countryName;
    }

    public void setcountryName(String countryName) {
        this.countryName = countryName;
    }
    public int getpassportNumber() {
        return passportNumber;
    }

    public void setpassportNumber(int passportNumber) {
       this.passportNumber = passportNumber;
    }

}


