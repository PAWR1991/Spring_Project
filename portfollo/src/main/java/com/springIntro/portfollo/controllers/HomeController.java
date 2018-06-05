package com.springIntro.portfollo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@RequestMapping("/")
	  public String index() {
		return "index.jsp";
    }
	
	@RequestMapping("/about")
	public String hello() {
		return"forward:/about.html";
	}
	
	@RequestMapping("/project")
	public String world() {
		return "forward:/project.html";
	}
	
}