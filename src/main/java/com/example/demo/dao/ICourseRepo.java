package com.example.demo.dao;

import com.example.demo.models.AuthGroup;
import com.example.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepo extends JpaRepository<Course,Long> {
	List<AuthGroup> findByCoursename(String cName);
}