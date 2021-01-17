package com.luv2code.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.dialect.pagination.FirstLimitHandler;



@Entity
@Table(name="instructor")
public class InstructorOneToManyB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String emailAdd;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, 
//			CascadeType.REMOVE, CascadeType.REFRESH, 
//			CascadeType.DETACH, CascadeType.MERGE})
	
	//mappedBy is to tell hibernate to 
	//look for instructor_id in the Course class
	
	//Mapping to Courses One To Many
	@OneToMany(mappedBy="instructorOneToManyB",cascade = {CascadeType.PERSIST, 
			CascadeType.REFRESH,CascadeType.DETACH, CascadeType.MERGE})
	private List<CourseOneToMany> allCourses;
	
	public List<CourseOneToMany> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(List<CourseOneToMany> allCourses) {
		this.allCourses = allCourses;
	}

	
	//mapping to instructor details
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetailBiDirectional instructorDetailBiDirectional;
	
	public InstructorDetailBiDirectional getInstructorDetailBiDirectional() {
		return instructorDetailBiDirectional;
	}

	public void setInstructorDetailBiDirectional(InstructorDetailBiDirectional instructorDetail) {
		this.instructorDetailBiDirectional = instructorDetail;
	}
	
	
	public InstructorOneToManyB() {
		
	}

	public InstructorOneToManyB(String firstName, String lastName, 
			String emailAdd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	
	public void add(CourseOneToMany course) {
		if(allCourses == null) {
			allCourses = new ArrayList<CourseOneToMany>();
		}
		
		allCourses.add(course);
		course.setInstructorOneToManyB(this);
	}

	    
	@Override
	public String toString() {
		return "Instructor [Id = " +id +", FirstName = " + firstName
				+ ", Last Name = " + lastName + ", Email = " + emailAdd + "]";
	}
} 
