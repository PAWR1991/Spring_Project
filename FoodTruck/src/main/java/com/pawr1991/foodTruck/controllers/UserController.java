package com.pawr1991.foodTruck.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawr1991.foodTruck.models.FoodTruck;
import com.pawr1991.foodTruck.models.Review;
import com.pawr1991.foodTruck.models.User;
import com.pawr1991.foodTruck.services.FoodTruckService;
import com.pawr1991.foodTruck.services.ReviewService;
import com.pawr1991.foodTruck.services.UserService;
import com.pawr1991.foodTruck.validators.UserValidator;

@Controller
public class UserController {
	
	private UserValidator userVal;
	private UserService userService;
	private FoodTruckService ftservice;
	private String[] stars = {"★★★★★","★★★★☆","★★★☆☆","★★☆☆☆","★☆☆☆☆"};
	private ReviewService revService;
	
	public UserController(UserValidator userVal, UserService userService,FoodTruckService ftservice,ReviewService revService) {
		this.userVal = userVal;
		this.userService = userService;
		this.ftservice = ftservice;
		this.revService=revService;
	
	}
	
	@RequestMapping("")
	public String index(HttpSession session) {
		session.setAttribute("user", this.userService.findById(1L));
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
			return "redirect:/dashboard";
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
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/dashboard")
	public String foodTrucks(Model model) {
		model.addAttribute("foodtrucks", this.ftservice.findAll());
		return "dashboard";
	}
	
	@RequestMapping("/foodtrucks/new")
	public String newFoodtruck(Model model) {
		model.addAttribute("foodtruck", new FoodTruck());
		return "new";
	}
	
	@PostMapping("/foodtrucks")
	public String foodtrucks(@Valid @ModelAttribute("foodtruck") FoodTruck foodtruck, BindingResult result) {
		System.out.println(foodtruck.getOp());
		System.out.println(foodtruck.getName());
		if (result.hasErrors()) {
			return "new";
		}
		ftservice.create(foodtruck);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/foodtruck/{id}/edit")
	public String editFoodtruck(Model model, @PathVariable("id") Long id) {
		model.addAttribute("foodtruck", this.ftservice.findById(id));
		return "edit";
	}
	
	@PostMapping("/foodtruck/{id}/update")
	public String updateFoodtruck( @Valid @ModelAttribute("foodtruck") FoodTruck foodtruck, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit";
		}else {
			this.ftservice.update(foodtruck);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/foodtruck/{id}")
	public String reviewFoodtruck(Model model, @PathVariable("id") Long id) {
		model.addAttribute("foodtruck", this.ftservice.findById(id));
		model.addAttribute("comment", new Review());
		
		model.addAttribute("stars", stars);
		return "foodtruck";
	}
	
	@PostMapping("/foodtruck/{id}/review")
	public String review( @Valid @ModelAttribute("comment") Review review, BindingResult result, @PathVariable("id") Long id, Model model) {
		System.out.println(review.getRating());
		if (result.hasErrors()) {
			model.addAttribute("foodtruck", this.ftservice.findById(id));
			model.addAttribute("stars", stars);
			return "foodtruck";
		}else {
			review.setId(null);
			Review r = this.revService.create(review);
			FoodTruck t = this.ftservice.findById(id);
			
			List<Review> reviews = t.getReviews();
			Double sum=0.0;
			for(Review rev: reviews) {
				sum += rev.getRating();
			}
			t.setAvgRating(sum/reviews.size());
			this.ftservice.update(t);
			return "redirect:/foodtruck/"+id;

		}
	}
}
