package com.mobilelife.dbutils;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateSessionManager {
	private static Logger logger = LoggerFactory.getLogger(HibernateSessionManager.class);

    private static final SessionFactory ourSessionFactory;

    static {
        try {

            ourSessionFactory = new AnnotationConfiguration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
          //  System.err.println("Initial SessionFactory creation failed." + ex);
        	logger.error("THROWABLE",ex);
            logger.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }


    public static void closeSession() throws HibernateException {
//        ourSessionFactory.close();
    }

}
