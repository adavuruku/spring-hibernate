package com.luv2code.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.dialect.pagination.FirstLimitHandler;

@Entity
@Table(name="studentcourse")
public class StudentCourse {

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
	

	//we have JoinTable called course_student in this table
	// we have the id of course and student link together
	// this table hold the relationship between the two tables
	//course and students
	// joinColumn is the representation of this table id
	// inverseJoinColumns is the ID OF THE Item on the other side
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id")
			)
	private List<CourseOneToMany> courses;
	
	
	
	public List<CourseOneToMany> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseOneToMany> courses) {
		this.courses = courses;
	}

	public StudentCourse() {
		
	}

	public StudentCourse(String firstName, String lastName, 
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

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAdd="
				+ emailAdd + "]";
	}
	
	public void addCourse(CourseOneToMany courseOneToMany) {
		if(courses == null) {
			courses = new ArrayList<CourseOneToMany>();
		}
		courses.add(courseOneToMany);
	}
	    
	
} 
