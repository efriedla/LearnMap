package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Learner;
import com.example.demo.services.CourseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("course")
@Log
public class CoursesControllerAPI {

	@Autowired
	private final CourseService courseService;

	public CoursesControllerAPI(CourseService courseService) {
		this.courseService = courseService;
	}

	// creates student object that can remeber what was entered for sessions
	@ModelAttribute("courseObject")
	public String courseObject() {
		return "";
	}
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> courses =  courseService.findAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}


//	@GetMapping("/find/{id}")
//	public ResponseEntity<Course> getCourseById (@PathVariable Long id){
//		Course course =  courseService.findCourseById(id);
//		return new ResponseEntity<>(course, HttpStatus.OK);
//	}
//
//	@PostMapping("/add")
//	public ResponseEntity<Course> addCourse(@RequestBody Course course){
//		Course newCourse = courseService.addCourse(course);
//		return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
//	}
//
//	@PutMapping("/update")
//	public ResponseEntity<Course> updateCourse(@RequestBody Course course){
//		Course updateCourse = courseService.updateCourse(course);
//		return new ResponseEntity<>(updateCourse, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> deleteCourse(@PathVariable Long id){
//		courseService.deleteCourse(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}
