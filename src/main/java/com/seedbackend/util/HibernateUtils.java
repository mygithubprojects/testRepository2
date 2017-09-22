package com.seedbackend.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private HibernateUtils() {};
   
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
    	if (sessionFactory == null) {
            // loads configuration and mappings
    		sessionFactory = new Configuration().configure()
    				.buildSessionFactory();           
        }

        return sessionFactory;
    }
    
   public static void shutdown() {
        getSessionFactory().close();
    }
	
}
