package com.restApi.springRest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restApi.springRest.entities.Course;


public interface CourseServices {
	
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	
	public List<Course> addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long courseId);

}
