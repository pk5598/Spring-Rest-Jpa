package com.restApi.springRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.springRest.entities.Course;
import com.restApi.springRest.services.CourseSerImp;
import com.restApi.springRest.services.CourseServices;

@RestController
public class MyController {
	
	@GetMapping("/home")
	public String name() {
		return "This is homepage";
	}
	
	@Autowired
	private CourseServices courseServices;
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		
		return courseServices.getCourses();
		
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
	
		
		return courseServices.getCourse(Long.parseLong(courseId));
		
		
	}
	
	
	@PostMapping(path="/courses",consumes = "application/json")
	public List<Course> addCourse(@RequestBody Course course) {
		return courseServices.addCourse(course);
		
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody  Course course) {
		return courseServices.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseServices.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
		   return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	

}
