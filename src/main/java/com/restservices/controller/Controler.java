package com.restservices.controller;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.MediaType;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import com.restservices.controller.entities.Course;
//import com.restservices.controller.entities.Enroll;
//import com.restservices.controller.entities.Form;
import com.restservices.helper.Helper;
//import com.restservices.implinterface.Ashish;

@RestController
// This cross origin annotation enable the browser the request the server from other port-no,other domain-name etc
//(origins = "http://localhost:4200")
@CrossOrigin
public class Controler {
	
//	@Autowired
//	@Qualifier(value = "myImpl")
//	private Ashish obj ;
	
	// Spring Boot application by default creates DataSource Object if we specify the data-source 
	// property in the application.properties file . so , we can easily autowire JdbcTemplate 
	// object as it requires only one dependency which is dataSource . 
	
//	@Autowired
//	private JdbcTemplate jTemplate ;

	// If you are going to use Spring Data JPA (as your pom.xml would suggest) 
	// there's no sense in using obsolete HibernateTemplate. 
	// Spring Boot doesn't create SessionFactory bean when Spring Data JPA is in use, 
	// however it creates EntityManagerFactory and HibernateTemplate requires to have a dependency of 
	// SessionFactory which in turn requires few more dependencies .
	
	// If the return type of the post method is Anything other than void
	// then angular need to pass the responseType: 'text' ;  
	// All the data is received in JSON format only at the server, so always use 
	// consumes = MediaType.APPLICATION_JSON_VALUE 

//	@PostMapping(path = "/formupload" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
//	public Form uploadForm(@RequestBody Form form) {
//		System.out.println(form);
//		obj.submitForm(form);
//		return form;
//	}
	
	@PostMapping("/upload-image")
	public String uploadImage(@RequestParam("img") MultipartFile file) throws Exception {
		
		boolean uploadImage = false;
		uploadImage = Helper.uploadImage(file);
		
		if(uploadImage == true) {
			return "Uploaded";
		}
		else {
			return "Something went wrong";
		}
	}
	
	//  @PathVariable annotation is used only when when data is passed to url like (/ajax/15)
	//	@PostMapping(path = "/ajaxpost")
	//	public List<Enroll> Practice(@RequestParam("name") String data) {
	//		return this.obj.getReqStudents(data);
	//	}
	
	@GetMapping(path = "/jslearn")
	public String method() {
		String text = "<h2 style=\"font-weight: lighter;\">Ashish is my name</h2>\r\n" + 
				"    <h1 style=\"font-weight: lighter;\">I have been living in US for 6 years</h1>";
		return text;
	}
	
//	@GetMapping(path = "/ajaxget")
//	public List<Enroll> Prac(@RequestParam("name") String data) {
//		return this.obj.getReqStudents(data);
//	}
	
//	@PostMapping(path = "/form")
//	public ResponseEntity<String> submitForm(@RequestBody Enroll enroll) throws Exception {
//		Thread.sleep(1000);
//		if(this.obj.submitForm(enroll) == true) {
//			return new ResponseEntity<String>("Submitted",HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
//	@GetMapping(path = "/students")
//	public List<Enroll> getAll(){
//		return this.obj.getStudents();
//	}
	
//	@RequestMapping(value = {"courses","allcourses"},method = RequestMethod.GET)
//	public List<Course> getcourses() throws InterruptedException {
//		Thread.sleep(4000);
//		List<Course> crs = this.obj.getCourses();
//		return crs;
//	}	
//	
//	@RequestMapping(path = "/course/{courseId}/{id}" ,method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
//	public Course getCourse(@PathVariable(name = "courseId") int cId ,@PathVariable(name = "id") int id) {
//		System.out.println(cId);
//		System.out.println(id);
//		return this.obj.getCourse(cId);		
//	}
	
	// consumes means what api is going to consume in order to give the result
	// produces means what type of result is going to be returned by the api
	// If we are returning a Java Object or list then produces should be MediaType.APPLICATION_JSON_VALUE
	// If we are returning a Plain string then produces should be MediaType.APPLICATION_PLAIN_VALUE
//	@PostMapping(path = "/allcourses", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
//	public Course addCourse(@RequestParam("id") int id , @RequestParam("name") String name, @RequestParam("desc") String desc) {
//		Course crs = new Course(id,name,desc);
//		System.out.println(crs);
//		return this.obj.addCourse(crs);
//	}
	
//	@GetMapping(path = "/coursess",produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Enroll> addCourse1() {
//		String query = "select * from sign_up_form" ; 
//		return this.jTemplate.query(query,new RowMapper<Enroll>() {
//
//			@Override
//			public Enroll mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Enroll obj = new Enroll();
//				obj.setId(rs.getInt(1));
//				obj.setCourse(rs.getString(2));
//				obj.setEmail(rs.getString(3));
//				obj.setName(rs.getString(4));
//				obj.setOffer(rs.getBoolean(5));
//				obj.setPhone(rs.getString(6));
//				obj.setTimeslot(rs.getString(7));
//				return obj ; 				
//			}
//		});
//	}
	
	// @RequestBody annotation tells spring boot to deserialize the HttpResponse Body and convert the JSON 
	// object into Java Object and this whole process of deserialization is done by HttpMessageConverter
	// A specialization of HttpMessageConverter that can convert an HTTP request into a target object of a specified generic type and a source object of a specified generic type into an HTTP response.
	// @ResponseBody annotation tells spring boot to serialize Java Object into Http Response
//	@PutMapping(path = "/update")
//	public Course updateCourse(@RequestBody Course course) {
//		return this.obj.updateCourse(course);
//	}
	
//	@RequestMapping(path = "/forms" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Form> getForms() throws InterruptedException {
//		Thread.sleep(2000);
//		List<Form> ans = this.obj.getForms();
//		return ans ;
//	} 
	
//	@DeleteMapping(path = "/delete/{id}" )
//	public String deleteCourse(@PathVariable int id){
//		boolean f = this.obj.deleteCourse(id);
//		return f ? "Object is deleted successfully !!!" : "Object is not deleted successfully !!!"; 
//	}
}