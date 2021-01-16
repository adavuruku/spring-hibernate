package com.luv2code.jdbc;

import org.hibernate.cfg.Configuration;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CreateStudentDemo {

	public static void main(String[] args) {
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//		
		
//		SessionFactory factory = new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Student.class)
//				.buildSessionFactory();
//		Session session = factory.getCurrentSession();
        
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//        Session session = factory.openSession();  
//        Transaction t = session.beginTransaction();  
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
//			Transaction t = session.beginTransaction(); 
			session.beginTransaction();
			//create
			Student student = new Student("Abel", "Dikko", "abeldiko@gmail.com", DateUtils.parseDate("31/12/1998"));
System.out.println(student.getId());
						session.save(student);
						
						String hql = "INSERT INTO Student(first_name, last_name, email, date_of_birth)"  + 
					             " VALUES (:firstName, :lastName, :EmailAdd, :dateOfBirth)";
					Query query = session.createNativeQuery(hql);
					query.setParameter("firstName", "Joseph");
					query.setParameter("lastName", "Anare");
					query.setParameter("EmailAdd", "joseph@outsource.com");
					query.setParameter("dateOfBirth", DateUtils.parseDate("31/12/1998"));
					int result = query.executeUpdate();
					System.out.println("Rows affected: " + result);
					
					session.getTransaction().commit();
			
			//retrieve single record
//			Student studentResult = session.get(Student.class, 2);
//			if(studentResult != null) {
//				System.out.println(studentResult.toString());
//			}else {
//				System.out.println("User Not Found !!");
//			}
			
			//retrieve record using HQL - Hibernate Query Language
//			1.
//			List<Student>  theStudentList = session.createQuery("from Student")
//					.getResultList();
			
//			2.
//			List<Student>  theStudentList = session.createQuery("from Student s where s.firstName ='Hawa' "
//					+ "OR s.lastName='Onize'")
//					.getResultList();
			
//			3.
//			List<Student>  theStudentList = session.createQuery("from Student s where s.emailAdd like '%@gmail.com'")
//					.getResultList();
//			
//			Iterator iterator = theStudentList.iterator();
//			for (; iterator.hasNext();) {
//				Student student2 = (Student) iterator.next();
//				System.out.println(student2.toString());
//			}
			
//			4.
//			String hql = "FROM Student s WHERE s.id = :studentId";
//			Query query = session.createQuery(hql);
//			query.setParameter("studentId",3);
//			List<Student> results = query.getResultList();
//			for(Student st: results) {
//				System.out.println(st.toString());
//			}
			
//			4.
//			String hql = "select s.firstName FROM Student s ORDER BY s.firstName DESC ";
//			Query query = session.createQuery(hql);
//			List<String> results = query.getResultList();
//			for(String st: results) {
//				System.out.println(st);
//			}
			
			
			//Updating
//			session.beginTransaction();
//			Student studentUpdate = session.get(Student.class, 2);
//			if(studentUpdate != null) {
//				studentUpdate.setEmailAdd("hawa2000@yahoo.com");
//				System.out.println(studentUpdate.toString());
//			}else {
//				System.out.println("User Not Found !!");
//			}
//			
//			
//			
//			String hql = "UPDATE Student set firstName = :firstName "  + 
//		             "WHERE id = :studentId";
//			Query query = session.createQuery(hql);
//			query.setParameter("firstName", "Oricha");
//			query.setParameter("studentId", 3);
//			int result = query.executeUpdate();
//			session.getTransaction().commit();
//			System.out.println("Rows affected: " + result);
//			
		
		//deleting
//		session.beginTransaction();
//		Student studentUpdate = session.get(Student.class, 2);
//		if(studentUpdate != null) {
//			session.delete(studentUpdate);
//			session.getTransaction().commit();
//		}else {
//			System.out.println("User Not Found !!");
//		}
//		
//		
//		String hql = "Delete Student WHERE id = :studentId";
//		Query query = session.createQuery(hql);
//		query.setParameter("studentId", 3);
//		int result = query.executeUpdate();
//		session.getTransaction().commit();
//		System.out.println("Rows affected: " + result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
