package com.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

//import com.restservices.implinterface.Ashish;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
//		boolean b = run.containsBeanDefinition("myImpl");
//		boolean c = run.containsBean("serviceImpl");
//		
//		Ashish obj = run.getBean("serviceImpl" , Ashish.class);
//		System.out.println(obj);
//		System.out.println(b);
//		System.out.println(c);
	}
}