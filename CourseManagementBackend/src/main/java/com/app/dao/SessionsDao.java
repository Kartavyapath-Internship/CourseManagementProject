package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Sessions;

public interface SessionsDao extends JpaRepository<Sessions, Integer> {

}
