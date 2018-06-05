package com.pawr1991.loginRegistration.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawr1991.loginRegistration.models.User;
import com.pawr1991.loginRegistration.services.UserService;
import com.pawr1991.loginRegistration.validators.UserValidator;

@Controller
public class UserController {
	
	private UserValidator userVal;
	private UserService userService;
	
	public UserController(UserValidator userVal, UserService userService) {
		this.userVal = userVal;
		this.userService = userService;
	}
	
	@RequestMapping("")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam Map<String, String> body, RedirectAttributes flash,HttpSession session) {
//		System.out.println(body);
		HashMap<String,Object> results = userVal.registerV(body);
//		System.out.println(results);
		if ((boolean)results.get("valid")) {
			session.setAttribute("user", this.userService.create(body));
			return "redirect:/";
		}
		else {
			flash.addFlashAttribute("errors", results);
			return "redirect:/registration";
		}
		
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> body, RedirectAttributes flash, HttpSession session) {
		User user = this.userVal.login(body);
		if(user != null) {
			flash.addFlashAttribute("msg", String.format("Welcome back: %s!", user.getUsername()));
			session.setAttribute("user", user);
		}else {
			flash.addFlashAttribute("msg", "Invalid information");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
