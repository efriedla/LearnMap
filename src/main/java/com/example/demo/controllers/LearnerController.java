package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Learner;
import com.example.demo.services.LearnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


@Controller
@RequestMapping("learner")
@Log
public class LearnerController {
	@Autowired
	private final LearnerService learnerService;

	public LearnerController(LearnerService learnerService) {
		this.learnerService = learnerService;
	}

	//create learner
//	@GetMapping("/register")
//	public String LearnerRegistration(){
//		return "registerUser";
//	}
	@PostMapping("/register")
	public String studentRegister(@ModelAttribute("learner") @Valid Learner learner, BindingResult result, Model model) {
		if(result.hasErrors()) {
			log.info("Student registration form is invalid");
			return "registerUser";

		}else{
			log.info("Created student " + learner.getEmail());
			Learner databaseStudent = learnerService.addLearner(learner);
			model.addAttribute("learner", learner);
			return "learnerConfirmation";
		}
	}


//	@PostMapping("/register")
//	public String studentRegister(@ModelAttribute("learner") @Validated Learner learner, BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			log.info("Student registration form is invalid");
//			return "registerUser";
//
//		}else{
//			log.info("Created student " + learnerService);
//			Learner savingLearner = learnerService.addLearner(learner);
//			model.addAttribute("learner", learner);
//			return "home";
//		}
//	}
	@GetMapping("/allLearners")
	public String findAllLearners(Model model){
		//show in page
//		log.info((Supplier<String>) learnerService.findAllLearners());
//		log.info((Supplier<String>) learnerService.findLearnerById(0L));
		model.addAttribute("learners", learnerService.findAllLearners());
		return "allLearners";
	}
	@GetMapping("/{id}")
	public String learnerHome(Model model, @PathVariable Long id,  Principal principal){
		//show in page
//		log.info((Supplier<String>) learnerService.findAllLearners());
//		log.info((Supplier<String>) learnerService.findLearnerById(principal));
//		log.info((Supplier<String>) learnerService.findLearnerById(id).getCourses());
		Learner found =  learnerService.findLearnerById(id);
		model.addAttribute("learner", found);
		return "learnerHome";
	}

//	@PutMapping("/{id}/courses/")
//	public String learnersCourses(Model mode, @PathVariable Long id){
//		Learner learner = learnerService.findLearnerById(id);
//
//	}



}
