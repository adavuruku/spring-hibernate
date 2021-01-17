package com.luv2code.jdbc;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.dialect.pagination.FirstLimitHandler;

@Entity
@Table(name="instructor_detail")
public class InstructorDetailBiDirectional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@OneToOne(mappedBy = "instructorDetailBiDirectional", cascade = CascadeType.ALL)
	private InstructorBiDirectional instructorBiDirectional;
	
	

	public InstructorDetailBiDirectional() {
		
	}

	public InstructorDetailBiDirectional(String hobby, String youtubeChannel) {
		this.hobby = hobby;
		this.youtubeChannel = youtubeChannel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	    
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public InstructorBiDirectional getInstructorBiDirectional() {
		return instructorBiDirectional;
	}

	public void setInstructorBiDirectional(InstructorBiDirectional instructorBiDirectional) {
		this.instructorBiDirectional = instructorBiDirectional;
	}
	@Override
	public String toString() {
		return "Instructor Detail [Id = " +id +", Hobby = " + hobby
				+ ", Youtube Channel = " + youtubeChannel + "]";
	}
} 
