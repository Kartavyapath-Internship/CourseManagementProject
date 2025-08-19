package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BatchCycle;
import com.app.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	
	Optional<Course> findByName(String name);


}
