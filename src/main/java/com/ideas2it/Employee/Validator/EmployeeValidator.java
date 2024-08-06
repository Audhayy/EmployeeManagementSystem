package com.ideas2it.Employee.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.Department.Service.DepartmentService;
import com.ideas2it.Department.DAO.DepartmentRepository;

public class EmployeeValidator{ 	
    public static boolean isValidUsername(String name) 
    { 
        String regex = "^[A-Za-z]\\w{5,29}$"; 
        Pattern pattern = Pattern.compile(regex); 
        if (name == null) { 
	    return false; 
        } 
	Matcher matcher = pattern.matcher(name);
	return matcher.matches(); 
	}
        public static boolean isValidEmail(String emailID)
        {
            Pattern pattern =Pattern.compile("^\\b[A-za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
                                                
            if(emailID.isEmpty()) {
                return false;
            }
            Matcher matcher =pattern.matcher(emailID);
            return matcher.matches();
        }
        public static boolean isValidPhoneNumber(String PhoneNum)
        {
         Pattern pattern = Pattern.compile("^\\d{10}$");
         Matcher matcher = pattern.matcher(PhoneNum);
         return matcher.matches();
        }

         
      


} 

