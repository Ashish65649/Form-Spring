package com.restservices.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.controller.entities.User;

@RestController
@CrossOrigin
public class FormController {

	@PostMapping(path = "/submit" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public User submitForm(@RequestBody User user) {
		System.out.println(user);
		return user ;
	}
	
}