package com.app.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.CourseModule;

@Repository
public interface CourseModuleDao extends JpaRepository<CourseModule, Integer>{

	@Query("SELECT m FROM CourseModule m JOIN m.courses c WHERE c.id = :courseId")
    List<CourseModule> findAllByCourseId(Integer courseId);
	
}
