package com.pawr1991.project.controllers;

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

import com.pawr1991.project.models.Review;
import com.pawr1991.project.models.TvShow;
import com.pawr1991.project.models.User;
import com.pawr1991.project.services.ReviewService;
import com.pawr1991.project.services.TvShowService;
import com.pawr1991.project.services.UserService;
import com.pawr1991.project.validators.TvShowValidator;
import com.pawr1991.project.validators.UserValidator;

@Controller
public class UserController {
	
	private UserValidator userVal;
	private UserService userService;
	private TvShowService tvService;
	private ReviewService revService;
	private TvShowValidator tvVal;
	
	public UserController(UserValidator userVal, UserService userService,TvShowService tvService,TvShowValidator tvVal,ReviewService revService) {
		this.userVal = userVal;
		this.userService = userService;
		this.tvService = tvService;
		this.tvVal = tvVal;
		this.revService = revService;
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
			return "redirect:/dashboard";
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
			return "redirect:/dashboard";
		}else {
			flash.addFlashAttribute("msg", "Invalid information");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// Dashboard
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
//		session.setAttribute("user", this.userService.findById(1L));
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("tvShows", this.tvService.findAll());
		return "dashboard";
	}
	
	// Making a new Tv show
	@RequestMapping("/show/new")
	public String newTvShow(Model model) {
		model.addAttribute("tvShow", new TvShow());
		return "newTvShow";
	}
	
	@PostMapping("/show/new")
    public String createTvShow(@Valid @ModelAttribute("tvShow") TvShow tvShow, BindingResult result, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
            return "newTvShow";
        }else{
        	if (!this.tvVal.isUnique(tvShow)) {
        		model.addAttribute("tvShow", tvShow);
    			model.addAttribute("msg", "Tv Show already exists");
        		return "newTvShow";
        	}
        	this.tvService.create(tvShow);
        	return "redirect:/dashboard";
        	
        }
    }
	
	//info Page for one Tv Show 
	@RequestMapping("/show/{id}")
	public String tvShow(@Valid @ModelAttribute("review") Review review, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		
		model.addAttribute("tvShow", this.tvService.findById(id));
		return "tvShow";
	}
	
	
	//Edit Section
	@RequestMapping("/show/{id}/edit")
	public String editTvShow(Model model,  @PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("tvShow", this.tvService.findById(id));
		return "edit";
	}
	
	@PostMapping("/show/{id}/edit")
    public String editTvShow(@Valid @ModelAttribute("tvShow") TvShow tvShow, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
        	model.addAttribute("tvShow", this.tvService.findById(id));
            return "edit";
        }else{
        	if (!this.tvVal.isUnique(tvShow)) {
    		model.addAttribute("tvShow", tvShow);
			model.addAttribute("msg", "Tv Show already exists");
    		return "edit";
    	}
        this.tvService.update(tvShow);
        model.addAttribute("tvShows", this.tvService.findAll());
        return "redirect:/dashboard";

        	
        }
	}
	
	// Review Section
	@PostMapping("/show/{id}/review")
    public String reviewTvShow(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		User sUser = (User) session.getAttribute("user");
		User checkUser = this.userService.findById(sUser.getId());
		
			// To stop a user from over 
			for(Review rev1: checkUser.getReviews()) {
				System.out.println("Heloo");
	    		if(rev1.getTvShow().getId() == id) {
	    			model.addAttribute("tvShow", this.tvService.findById(id));
	    			model.addAttribute("msg", "A user cannot rate a tv show more than once");
	    			return "tvShow";
	    		}
			}
		
		
		
		// making the rating
		if (result.hasErrors()) {
        	model.addAttribute("tvShow", this.tvService.findById(id));
            return "tvShow";
        }else{   
        	review.setId(null);
        	this.revService.create(review);
        	TvShow tv = this.tvService.findById(id);
        	List<Review> reviews = tv.getReviews();
        	Double sum = 0.0;
        	for(Review rev: reviews) {
        		sum += rev.getRating();
        	}
        	tv.setAvgRating(sum/reviews.size());
        	this.tvService.update(tv);
        	
        	return "redirect:/show/"+id;
        	
        }
        
	}
	
	// Delete
	@RequestMapping("show/{id}/delete")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		TvShow tv = this.tvService.findById(id);
//		if (session.getAttribute("user") != tv.getOp()) {
//			return "redirect:/dashboard";
//		}
	
    	List<Review> reviews = tv.getReviews();
    	for(Review rev: reviews) {
    		this.revService.delete(rev.getId());
    	}
		this.tvService.delete(id);
		return "redirect:/dashboard";
	}
}
