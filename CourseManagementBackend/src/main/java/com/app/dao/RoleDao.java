package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
