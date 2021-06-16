package com.example.demo.controllers;

import com.example.demo.models.Learner;
import com.example.demo.services.LearnerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("learner")
@Log
public class LearnerController {
	@Autowired
	private final LearnerService learnerService;

	public LearnerController(LearnerService learnerService) {
		this.learnerService = learnerService;
	}

	// creates student object that can remeber what was entered for sessions
	@ModelAttribute("learnerObject")
	public String learnerObject() {
		return "";
	}

	@GetMapping("/template")
	public String test(){
		System.out.println("inside index action");
		return "template";
	}
	@GetMapping({"/","index"})
	public String index(){
		System.out.println("******** in LEarner Controller!!!");
		return "index";
	}

	@GetMapping("/all")
	public ResponseEntity<List<Learner>> getAllLearner(){
		List<Learner> learners =  learnerService.findAllLearners();
		return new ResponseEntity<>(learners, HttpStatus.OK);
	}


	@GetMapping("/find/{id}")
	public ResponseEntity<Learner> getLearnerById (@PathVariable Long id){
		Learner learner =  learnerService.findLearnerById(id);
		return new ResponseEntity<>(learner, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Learner> addLearner(@RequestBody Learner learner){
		Learner newLearner = learnerService.addLearner(learner);
		return new ResponseEntity<>(newLearner, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Learner> updateLearner(@RequestBody Learner learner){
		Learner updateLearner = learnerService.updateLearner(learner);
		return new ResponseEntity<>(updateLearner, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteLearner(@PathVariable Long id){
		learnerService.deleteLearner(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
