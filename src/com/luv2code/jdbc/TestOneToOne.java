package com.luv2code.jdbc;

import org.hibernate.Session;

public class TestOneToOne {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
		
		session.beginTransaction();
		
		/*Instructor instructor = new Instructor("Hannat", 
				"Nagode H.", "hannannagode@gmail.com");
		
		InstructorDetail instructorDetail = new InstructorDetail("Movies", 
				"https://youtube.com/LO233in10Pq");
		
		instructor.setInstructorDetail(instructorDetail);
		
		session.save(instructor);*/
		
		/* //Deleting
		
		Instructor delInstructor = session.get(Instructor.class, 1);
		if(delInstructor != null) {
			session.delete(delInstructor);
			session.getTransaction().commit();
			System.out.println("You Deleted : " + delInstructor.toString()
			+ " And Details : " + delInstructor.getInstructorDetail().toString());
		}else {
			System.out.println("User Not Found !!!");
		}*/
		
		
		//Test Bidirectional
		
		
		/*InstructorDetailBiDirectional delInstructor = session.get(InstructorDetailBiDirectional.class, instructorDetail.getId());
		if(delInstructor != null) {
			System.out.println("Result : " + delInstructor.toString()
			+ " And Details : " + delInstructor.getInstructorBiDirectional().toString());
		}else {
			System.out.println("User Not Found !!!");
		}*/
		
		
			InstructorDetailBiDirectional delInstructor = session.get(InstructorDetailBiDirectional.class, 4);
			if(delInstructor != null) {
				session.delete(delInstructor);
				session.getTransaction().commit();
				System.out.println("Result : " + delInstructor.toString()
				+ " And Details : " + delInstructor.getInstructorBiDirectional().toString());
			}else {
				System.out.println("User Not Found !!!");
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
	}
	
}
