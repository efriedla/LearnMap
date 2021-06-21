package com.example.demo.dao;

import com.example.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Long> {
//	Optional<Course> findCourseById(Long cId);
}
