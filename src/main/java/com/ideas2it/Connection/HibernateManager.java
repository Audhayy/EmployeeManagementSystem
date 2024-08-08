package com.ideas2it.Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
*<p>
*This is a helper class to open a session a hibernate.
*</p>
*/
public class HibernateManager {
    private static SessionFactory factory = null; 

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) { 
            System.err.println("Failed to create sessionFactory object." + e);
            throw new ExceptionInInitializerError(e); 
        }
    }

    public static SessionFactory getFactory() { 
       return factory;
    }  
}