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
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne(cascade = {CascadeType.PERSIST, 
			CascadeType.REFRESH,CascadeType.DETACH, CascadeType.MERGE})
	@JoinColumn(name="course_id")
	private CourseOneToMany courseOneToMany;
	
	@Column(name="comment")
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//we dont need setters here since is uni-directional
	
//	public CourseOneToMany getCourseOneToMany() {
//		return courseOneToMany;
//	}
//
//	public void setCourseOneToMany(CourseOneToMany courseOneToMany) {
//		this.courseOneToMany = courseOneToMany;
//	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", courseOneToMany=" + courseOneToMany + ", comment=" + comment + "]";
	}

	public Review(String comment) {
		this.comment = comment;
	}
	
	public Review() {
	}
	
	

}
