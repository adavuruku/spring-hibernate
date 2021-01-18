package com.luv2code.jdbc;

import org.hibernate.Session;

public class TestManyToMany {
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
		
		
		//Delete A cOURSE
		CourseOneToMany delInstructorO = session.get(CourseOneToMany.class, 2);
		if(delInstructorO != null) {
			session.delete(delInstructorO);
			session.getTransaction().commit();
			System.out.println("Result : " + delInstructorO.toString());
		}else {
			System.out.println("Course Not Found !!!");
		}
		*/
		
		//test Uni directional
		//saving reviews
		/*// 1. Adding student to course
		CourseOneToMany courseOneToMany = session.get(CourseOneToMany.class, 3);
		
		StudentCourse studentCourse1 = new StudentCourse(
				"Samad", "Ojo", "ojo@gmail.com");
		
		StudentCourse studentCourse2 = new StudentCourse(
				"Mabel", "Abanijo", "abanijo@yahoo.com");
		
		StudentCourse studentCourse3 = new StudentCourse(
				"Musnad", "Funmilayo", "funmi@gmail.com");
		
		
		courseOneToMany.addStudent(studentCourse1);
		courseOneToMany.addStudent(studentCourse2);
		courseOneToMany.addStudent(studentCourse3);
		
		// u have to save the students first so they can have id to use
		// in the join table
		 * Note: that you can save the main object courseOneToMany directly without 
		 * saving all the studentCourse objects , reason because they dont have ids yet and cant be added to
		 * the join table.
		 * so u have to save them first so they can get an id. and as u save them the join 
		 * table also create its own records as well
		session.save(studentCourse1);
		session.save(studentCourse2);
		session.save(studentCourse3);
		
		session.getTransaction().commit(); */
		
	/*	//2. adding course to a student
		StudentCourse studentCourse = session.get(StudentCourse.class, 1);
		
		//fetch courses to register student for
		CourseOneToMany cour1 = session.get(CourseOneToMany.class, 5);
		CourseOneToMany cour2 = session.get(CourseOneToMany.class, 6);
		CourseOneToMany cour3 = session.get(CourseOneToMany.class, 7);
		CourseOneToMany cour4 = session.get(CourseOneToMany.class, 8);
		CourseOneToMany cour5 = session.get(CourseOneToMany.class, 9);
		
		//add the courses to student or link it to student
		studentCourse.addCourse(cour1);
		studentCourse.addCourse(cour2);
		studentCourse.addCourse(cour3);
		studentCourse.addCourse(cour4);
		studentCourse.addCourse(cour5);
		
		//save so the record can be added to join table
		//not here we are saving courses again since all we are working
		//are already been saved before now
		//so just save the studentCourse object - this will insert the necessary value in the join table
		session.save(studentCourse);
		session.getTransaction().commit();*/
		
		
		/*//3. fetching all courses a student registered
		StudentCourse studentCourse = session.get(StudentCourse.class, 1);
		System.out.println("Stuent Info ");
		System.out.println(studentCourse.toString());
		System.out.println("List Of Courses ");
		System.out.println(studentCourse.getCourses().toString());
		session.getTransaction().commit();*/
		
		/*//4. fetching all students that registered for a course
		CourseOneToMany courseOneToMany = session.get(CourseOneToMany.class, 3);
		System.out.println("Course Info ");
		System.out.println(courseOneToMany.toString());
		System.out.println("List Of Students  ");
		System.out.println(courseOneToMany.getStudents().toString());
		session.getTransaction().commit();*/
		
		/*//5. Deleting Course shouldn't affect Student [Note the Cascade Type set in their relationship] 
		// - But the entry in Join table will be deleted
		CourseOneToMany courseOneToMany = session.get(CourseOneToMany.class, 5);
		session.delete(courseOneToMany);
		session.getTransaction().commit();*/
		
		
	/*	//6. Deleting Student shouldn't affect Course [Note the Cascade Type set in their relationship] 
				// - But the entry in Join table will be deleted
		StudentCourse studentCourse = session.get(StudentCourse.class, 1);
		session.delete(studentCourse);
		session.getTransaction().commit();*/
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
			
			
			session.close();
		}
	}
	
}
