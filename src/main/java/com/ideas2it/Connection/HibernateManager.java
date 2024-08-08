package com.ideas2it.Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
<<<<<<< HEAD:com/Connection/HibernateManager.java
 *<p>
 *This is a helper class to open a session a hibernate.
 *</p>
 */
=======
*<p>
*This is a helper class to open a session a hibernate.
*</p>
*/
>>>>>>> 35322006f735f3ef1ea8664ac2997cab61300cac:src/main/java/com/ideas2it/Connection/HibernateManager.java
public class HibernateManager {
    private static final SessionFactory factory;

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