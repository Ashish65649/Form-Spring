package com.restservices.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.controller.entities.Course;
//import com.restservices.controller.entities.Enroll;
import com.restservices.controller.entities.Form;
import com.restservices.implinterface.Ashish;
import com.restservices.repo.FormRepo;

@Service
public class MyImpl implements Ashish {
	
	@Autowired
	private FormRepo repo;

	private List<Course> list = null;
	
	public boolean submitForm(Form form) {
		boolean f = false;
		this.repo.save(form);
		f = true;
		return f;
	}
	
	public List<Form> getForms() {
		Iterable<Form> forms = this.repo.findAll();
		List<Form> ans = new ArrayList<Form>();
		forms.forEach(form -> { ans.add(form); });
		return ans ;
	}

	public MyImpl() {
		
		list = new ArrayList<Course>();
		this.list.add(new Course(11,"Java","Java is a powerful language"));
		this.list.add(new Course(15,"Python","Python is a powerful language"));
	}

	@Override
	public List<Course> getCourses() {
		return this.list;
	}

	@Override
	public Course getCourse(int id) {
		Iterator<Course> itr = this.list.iterator();
		Course c = null;
		Course d = null;
		while(itr.hasNext()) {
			c = itr.next();
			if(c.getId() == id) {
				d = c;
				break;
			}
		}
		return d;
	}

	@Override
	public Course addCourse(Course c) {
		this.list.add(c);
		return c;
	}

	@Override
	public Course updateCourse(Course cr) {
		
		Iterator<Course> itr = this.list.iterator();
		Course c = null;
		while(itr.hasNext()) {
			c = itr.next();
			if(c.getId() == cr.getId()) {
				c.setName(cr.getName());
				c.setDesc(cr.getDesc());
			}
		}
		return c;
	}

	@Override
	public boolean deleteCourse(int id) {
		try {
			this.repo.deleteById(id);
			return true ;
		}
		catch(Exception e) {
			return false ; 
		}
	}
	
}