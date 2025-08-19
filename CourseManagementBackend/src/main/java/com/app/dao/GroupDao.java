package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Group;

public interface GroupDao extends JpaRepository<Group, Integer> {

}
