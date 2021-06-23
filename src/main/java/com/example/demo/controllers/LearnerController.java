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
import java.util.Optional;
import java.util.function.Supplier;


@Controller
@RequestMapping("learner")
@Log
public class LearnerController {

	private final LearnerService learnerService;
	@Autowired
	public LearnerController(LearnerService learnerService) {
		this.learnerService = learnerService;
	}

	//learner controller
	@ModelAttribute("learner")
	public Learner newLearner(){
		return new Learner();
	}

	@GetMapping("/register")
	public String registerStudent(){
		return "registerUser";
	}

	@PostMapping("/submit")
	public String newLearner(@ModelAttribute("learner") @Valid Learner learner, BindingResult result, Model model ){
		Optional<Learner> learnerbyemail = learnerService.findLearnerByEmail(learner.getEmail());
		if(learnerbyemail.isPresent()){
			throw new IllegalArgumentException("email taken");
		}else{
			Learner nLearner = learnerService.addLearner(learner);
			model.addAttribute("learner", nLearner);
			log.info( "added *** "+ nLearner);
			return "confirmLearner";
		}
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
//	@GetMapping("/{id}")
//	public String learnerHome(Model model, @PathVariable Long id,  Principal principal){
//		//show in page
////		log.info((Supplier<String>) learnerService.findAllLearners());
////		log.info((Supplier<String>) learnerService.findLearnerById(principal));
////		log.info((Supplier<String>) learnerService.findLearnerById(id).getCourses());
//		Learner found =  learnerService.findLearnerById(id);
//		model.addAttribute("learner", found);
//		return "learnerHome";
//	}
	@GetMapping("/{id}")
	public String profile(Model model, @PathVariable Long id){
		Learner found = learnerService.findLearnerById(id);
		model.addAttribute("learner", found);
		log.info("in profile "+ found.getUsername());
		return "learnerHome";
	}

	@GetMapping("/update/{id}")
	public String updateProfile(Model model, @PathVariable Long id){
		Learner found = learnerService.findLearnerById(id);
		model.addAttribute("learner", found);
		log.info("in profile "+ found.getUsername());
		return "learnerEdit";
	}
	@PostMapping("/save")
	public String editLearner(@ModelAttribute("learner") Model model, @Valid Learner learner, BindingResult result,
                              @RequestParam("id") Long id,@RequestParam("email") String email,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,@RequestParam("username") String username
	                          ){
		Learner bob = new Learner();
		bob.setId(id);
		bob.setFirstName(firstName);
		bob.setLastName(lastName);
		bob.setEmail(email);
		bob.setUsername(username);
		log.info(String.valueOf(bob));
		learnerService.updateLearner(bob);
		return"learnerHome";
	}


}
