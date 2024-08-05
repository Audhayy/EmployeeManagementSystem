package com.Model;

import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToOne;

import com.Model.Passport;
/**
  *This is a class created to associate with employee and 
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


