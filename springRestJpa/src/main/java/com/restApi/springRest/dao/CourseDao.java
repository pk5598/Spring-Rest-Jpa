package com.restApi.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.springRest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	

}
