package com.springFund.dojoSurvey.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@PostMapping("/process")
	public String process(@RequestParam Map<String, String> body, HttpSession session) {
		session.setAttribute("body", body);
		return "redirect:/submitted";
	}
	
	@RequestMapping("submitted")
	public String another() {
		return "submitted";
	}
	
}
