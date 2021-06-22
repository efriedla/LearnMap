package com.example.demo.controllers;


import com.example.demo.services.LearnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HomeController {


//	@GetMapping("/")
//	public String home() {
//		return "redirect:index";
//	}
@GetMapping({"test"})
public String ang() {
	return "AngularTemplate/list";
}


	@GetMapping({"/","index"})
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
	@GetMapping("/login")
	public String login(){
	System.out.println("***here");
		return "login";
	}
	//Seen if page is not accessible to user.
//	@GetMapping("/403")
//	public String forbidden() {
//		var user = SecurityContextHolder.getContext().getAuthentication();
//		StringBuilder auths = new StringBuilder();
//		for(var auth : user.getAuthorities()) {
//			auths.append(auth.getAuthority()).append(", ");
//		}
//		log.error("**** " + user.getName() + " Attempted to Access Forbidden Page with authority " + auths + "****");
//		return "403";
//	}

}
