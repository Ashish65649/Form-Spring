package com.restservices.controller.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SignUpForm")
public class Enroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(length = 50 , unique = true)
	private String email;
	private String phone;
	private String course;
	private String timeslot;
	private boolean offer;

	public Enroll() {
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", email=" + email + ", phone=" + phone + ", course=" + course + ", timeslot="
				+ timeslot + ", offer=" + offer + "]";
	}

	public Enroll(String name, String email, String phone, String course, String timeslot, boolean offer) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.course = course;
		this.timeslot = timeslot;
		this.offer = offer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public boolean isOffer() {
		return offer;
	}

	public void setOffer(boolean offer) {
		this.offer = offer;
	}	
	
	
	
}
