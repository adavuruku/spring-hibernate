package com.luv2code.jdbc;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC");
	                settings.put(Environment.USER, "root");
//	                settings.put(Environment.PASS,root);
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

	                settings.put(Environment.SHOW_SQL, "true");
	                
	                settings.put(Environment.POOL_SIZE, 1);

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//	                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	                configuration.setProperties(settings);

	                configuration.addAnnotatedClass(Student.class);
	                configuration.addAnnotatedClass(Instructor.class);
	                configuration.addAnnotatedClass(InstructorDetail.class);
	                configuration.addAnnotatedClass(InstructorDetailBiDirectional.class);
	                configuration.addAnnotatedClass(InstructorBiDirectional.class);
	                
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
}
