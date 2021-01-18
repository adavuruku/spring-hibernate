package com.luv2code.jdbc;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseOneToMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	//relationship to Instructor
	@ManyToOne(cascade = {CascadeType.PERSIST, 
			CascadeType.REFRESH,CascadeType.DETACH, CascadeType.MERGE})
	@JoinColumn(name="instructor_id")
	private InstructorOneToManyB instructorOneToManyB;
	
	
	//relationships to Reviews
	//since we want to use uni-directional = we applied @JoinColumn
	// it means only comment can fetch reviews
	// we cant retrieve comment using review
	// remember for bi- directional we use mappedBy
	//@OneToMany(mappedBy = "courseOneToMany", cascade= CascadeType.ALL)
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	//join column name is the name of the field that holds the foreign key id in the child table
	@JoinColumn(name = "course_id")
	private List<Review> allReviews;
	
	
	//we have JoinTable called course_student in this table
	// we have the id of course and student link together
	// this table hold the relationship between the two tables
	//course and students
	
	
	
	
	public List<Review> getAllReviews() {
		return allReviews;
	}

	public void setAllReviews(List<Review> allReviews) {
		this.allReviews = allReviews;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
			)
	private List<StudentCourse> students;
	
	public List<StudentCourse> getStudents() {
		return students;
	}

	public void setStudents(List<StudentCourse> students) {
		this.students = students;
	}

	
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
	
	public void addReview(Review review) {
		if(allReviews == null) {
			allReviews = new ArrayList<Review>();
		}
		allReviews.add(review);
//		review.setCourseOneToMany(this); // we dont need to link back to review since is uni-directional
	}
	
	public void addStudent(StudentCourse studentCourse) {
		if(students == null) {
			students = new ArrayList<StudentCourse>();
		}
		students.add(studentCourse);
	}
}
