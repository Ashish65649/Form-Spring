package com.restservices.controller.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_form")
public class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String email;
	private String pass;
	private String mobile;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Form [id=" + id + ", email=" + email + ", pass=" + pass + ", mobile=" + mobile + "]";
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Form(String email, String pass, String mobile) {
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
	}
	public Form() {
	}
}
