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
		System.out.println("inside index action");
		return "redirect:index";
	}
	@RequestMapping(value = "/index")
	public String index2() {
		System.out.println("inside index2 action");
		return "index";
	}

	@GetMapping("/template")
	public String template(){
		System.out.println("inside template action");
		return "template";
	}
}
