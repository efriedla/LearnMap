package com.example.demo.controllers;

import com.example.demo.models.Learner;
import com.example.demo.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("console")
public class AdminController {
	@Autowired
	private final LearnerService adminController;

	public AdminController(LearnerService adminController) {
		this.adminController = adminController;
	}

//	@GetMapping("/getallstudent")
//	public String getUsers(Model model){
//
//		return "getallstudent";
//	}

//	@PreAuthorize("hasAuthority('WRITE')") // bring back when using security

//	@GetMapping("/getlearnerbyid")
//	public String getLearnerById(){
//
//		return "learnerHome";
//	}

	@GetMapping("/allLearners")
	public String findAllLearners(Model model){
		//show in page
		model.addAttribute("learners", adminController.findAllLearners());
		return "allLearners";
	}
//	@PreAuthorize("hasAuthority('WRITE')") // bring back when using security
	@GetMapping("/{id}")
	public String learnerHome(Model model, @PathVariable Long id, Principal principal){
		//show in page
		Learner found =  adminController.findLearnerById(id);
		model.addAttribute("learner", found);
		return "learnerHome";
	}
}
