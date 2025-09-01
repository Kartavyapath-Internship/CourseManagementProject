package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.CourseModule;

@Repository
public interface CourseModuleDao extends JpaRepository<CourseModule, Integer>{

}
