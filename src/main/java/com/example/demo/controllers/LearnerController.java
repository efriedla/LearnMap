package com.example.demo.controllers;

import com.example.demo.models.Learner;
import com.example.demo.services.LearnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
//		System.out.println("here sdflkjsdlkjsf");
//		return "registerUser";
//	}

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

}
