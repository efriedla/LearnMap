package com.example.demo.services;

import com.example.demo.dao.ICourseRepo;
import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public List<Course> findAllCourses() { return courseRepo.findAll(); }

//	public Course findCourseById(Long id) {
//		//		return learnerRepo.findLearnerById(id).orElseThrow(() -> new UserPrincipalNotFoundException("User by id " + id + " was not found"));
//		return courseRepo.findCourseById(id);
//	}

	public Course addCourse(Course course) { return courseRepo.save(course);
	}

	public Course updateCourse(Course course) { return courseRepo.save(course);
	}

	public void deleteCourse(Long id) { courseRepo.deleteById(id);
	}
//	public Optional<Course> getCourseById(Long id) {
//		Optional<Course> courseOptional = courseRepo.findCourseById(id);
//		return courseOptional;
//	}
}
