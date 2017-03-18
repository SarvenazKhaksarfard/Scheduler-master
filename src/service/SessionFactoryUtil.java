package service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	private static SessionFactory session = buildSessionFactory();
	private SessionFactoryUtil(){}
	private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } 
        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	public static SessionFactory getInstance(){
		return session;
	}
}
