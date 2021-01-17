package com.luv2code.jdbc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.dialect.pagination.FirstLimitHandler;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String hobby, String youtubeChannel) {
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

	@Override
	public String toString() {
		return "Instructor Detail [Id = " +id +", Hobby = " + hobby
				+ ", Youtube Channel = " + youtubeChannel + "]";
	}
} 
