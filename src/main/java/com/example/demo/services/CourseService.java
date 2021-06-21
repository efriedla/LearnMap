package com.example.demo.services;

import com.example.demo.dao.ICourseRepo;
import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	private final ICourseRepo courseRepo;

	@Autowired
	public CourseService(ICourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}
	public Course saveCourse(Course course) {
		return courseRepo.save(course);
	}

	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}
//	public Optional<Course> getCourseById(Long id) {
//		Optional<Course> courseOptional = courseRepo.findCourseById(id);
//		return courseOptional;
//	}
}
