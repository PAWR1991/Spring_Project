package com.springIntro.learningPlatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearnPlatfromController {
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("m/{sect}/0553/{Num}")
	public String page(@PathVariable Integer sect, @PathVariable Integer Num, Model model) {
		if(Num == 733) {
			model.addAttribute("desc", "Fortran Set Up placeholder");
			return "lesson";
		}
		else if (Num == 342) {
			model.addAttribute("desc", "Fortran Punch Card placeholder");
			return "lesson";
		}
		else if (Num == 348) {
			model.addAttribute("desc", "Advanced Fortran Intro placeholder");
			return "lesson";
		}
		else if(Num == 345) {
			model.addAttribute("desc", "Fortran Coding Forms placeholder");
			return "assignment";
		}
		else if (Num == 2342) {
			model.addAttribute("desc", "Fortran to Binary placeholder");
			return "assignment";
		}
		else {
			return "redirect:/";
		}
		
	}
	
	
}
