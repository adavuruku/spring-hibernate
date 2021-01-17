package com.luv2code.jdbc;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.dialect.pagination.FirstLimitHandler;

@Entity
@Table(name="instructor")
public class InstructorBiDirectional {

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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetailBiDirectional instructorDetailBiDirectional;
	
	
	
	public InstructorBiDirectional() {
		
	}

	public InstructorBiDirectional(String firstName, String lastName, 
			String emailAdd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
	}
	

	public InstructorDetailBiDirectional getInstructorDetailBiDirectional() {
		return instructorDetailBiDirectional;
	}

	public void setInstructorDetailBiDirectional(InstructorDetailBiDirectional instructorDetail) {
		this.instructorDetailBiDirectional = instructorDetail;
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
		return "Instructor [Id = " +id +", FirstName = " + firstName
				+ ", Last Name = " + lastName + ", Email = " + emailAdd + "]";
	}
} 
