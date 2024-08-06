package com.ideas2it.customizedexception;

public class EmployeeException extends Exception {
   public EmployeeException(String message, Throwable throwable) {
	super(message, throwable);
    }

}