package com.app.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

    Optional<Course> findByName(String name);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Course c WHERE c.coordinator.id = :coordinatorId")
    boolean existsByCoordinatorId(@Param("coordinatorId") int coordinatorId);

}
