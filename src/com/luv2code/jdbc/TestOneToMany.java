package com.luv2code.jdbc;

import org.hibernate.Session;

public class TestOneToMany {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
		
		session.beginTransaction();
		
		/* //create Instructor
		InstructorOneToManyB instructor = new InstructorOneToManyB("Yusuf", 
				"Muhammed L.", "yusufmuhammed@gmail.com");
		
		//create Instructor Details
		InstructorDetailBiDirectional instructorDetail = new InstructorDetailBiDirectional("Movies", 
				"https://youtube.com/Hn0123FtyOl1");
		
		instructor.setInstructorDetailBiDirectional(instructorDetail);
		
		//create and add courses to Instructor
		CourseOneToMany course1 = new CourseOneToMany("Abstract Algebra");
		instructor.add(course1);
		CourseOneToMany course2 = new CourseOneToMany("Linear Algebra");
		instructor.add(course2);
		
		CourseOneToMany course3 = new CourseOneToMany("Calculus");
		instructor.add(course3);
		
		session.save(instructor);
		
		//SAVE COURSES
		session.save(course1);
		session.save(course2);
		session.save(course3);
		
		session.getTransaction().commit();
		
//		for(CourseOneToMany co: instructor.getAllCourses()) {
//			System.out.println(co.getTitle());
////		}
		
		 //Retrieving
		
		InstructorOneToManyB delInstructor = session.get(InstructorOneToManyB.class, 12);
		if(delInstructor != null) {
//			session.delete(delInstructor);
//			session.getTransaction().commit();
			System.out.println("Instructor : "+delInstructor.toString());
			System.out.println("Instructor Details : " +delInstructor.getInstructorDetailBiDirectional().toString());
			System.out.println("Courses List");
			for(CourseOneToMany co: delInstructor.getAllCourses()) {
				System.out.println(co.getTitle());
			}
			
		}else {
			System.out.println("User Not Found !!!");
		}
		*/
		
		//Delete A cOURSE
		CourseOneToMany delInstructorO = session.get(CourseOneToMany.class, 2);
		if(delInstructorO != null) {
			session.delete(delInstructorO);
			session.getTransaction().commit();
			System.out.println("Result : " + delInstructorO.toString());
		}else {
			System.out.println("Course Not Found !!!");
		}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
	}
	
}
