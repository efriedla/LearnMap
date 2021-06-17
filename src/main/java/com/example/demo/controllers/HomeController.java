package com.example.demo.controllers;


import com.example.demo.services.LearnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/template")
	public String template(){
		return "template";
	}

	@GetMapping("/404")
	public String error(){
		return "error";
	}
}
