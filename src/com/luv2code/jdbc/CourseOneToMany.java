package com.luv2code.jdbc;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="course")
public class CourseOneToMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne(cascade = {CascadeType.PERSIST, 
			CascadeType.REFRESH,CascadeType.DETACH, CascadeType.MERGE})
	@JoinColumn(name="instructor_id")
	private InstructorOneToManyB instructorOneToManyB;
	
	@Column(name="title")
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public CourseOneToMany() {
	}


	public CourseOneToMany(String title) {
		this.title = title;
	}

	public InstructorOneToManyB getInstructorOneToManyB() {
		return instructorOneToManyB;
	}

	public void setInstructorOneToManyB(InstructorOneToManyB instructorOneToManyB) {
		this.instructorOneToManyB = instructorOneToManyB;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}
