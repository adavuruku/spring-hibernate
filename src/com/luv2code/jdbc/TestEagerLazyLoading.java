package com.luv2code.jdbc;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class TestEagerLazyLoading {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
		// in Eager Loading - the table and all its related child tables are fetched once
			// in Lazy Loading only the main table is fetch and child are fetch when needed.
		
			session.beginTransaction();
		
			//Since we use the Join fetch. it will wor fine even session is close cause is already
			// into the memory
			Query<InstructorOneToManyB> query = session.createQuery("select i from InstructorOneToManyB i "
					+ "JOIN FETCH i.allCourses where i.id=:theInstructorId", InstructorOneToManyB.class);
			query.setParameter("theInstructorId",12);
			InstructorOneToManyB delInstructor = query.getSingleResult();
			System.out.println("Result : " + delInstructor);
			session.close(); 
			System.out.println("Courses : " + delInstructor.getAllCourses());
			
//			InstructorOneToManyB delInstructor = session.get(InstructorOneToManyB.class, 12);
//			if(delInstructor != null) {
//				System.out.println("Result : " + delInstructor);
//				session.close(); 
//				//for lazy fetching the getCourses will fail since session is close
//				//but in Eager loading it will work fine since we have fetch all info out b4 closing session
//				System.out.println("Courses : " + delInstructor.getAllCourses());
//			}else {
//				System.out.println("User Not Found !!!");
//			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
	}
	
}
