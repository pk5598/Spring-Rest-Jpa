package com.restApi.springRest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.springRest.dao.CourseDao;
import com.restApi.springRest.entities.Course;

@Service
public class CourseSerImp  implements CourseServices{
	
	@Autowired
    private CourseDao courseDao;
	
	public CourseSerImp() {
	
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		return courseDao.getOne(courseId);
		
	}

	@Override
	public List<Course> addCourse(Course course) {
		courseDao.save(course);
		return courseDao.findAll();
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
	   Course course=courseDao.getById(courseId);
	   courseDao.delete(course);
		
	}
	
	
	
	

}
