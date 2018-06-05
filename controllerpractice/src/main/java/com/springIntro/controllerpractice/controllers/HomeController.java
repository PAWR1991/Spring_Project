package com.springIntro.controllerpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@RequestMapping("/")
	  public String index() {
		return "forward:/index.html";
    }
	
	@RequestMapping("/hello")
	public String hello() {
		return"Hello World, everyone!";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
	
}
