package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CourseModule;

public interface CourseModuleDao extends JpaRepository<CourseModule, Integer> {

}
