package com.springData.movies.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springData.movies.models.Actor;
import com.springData.movies.models.Movie;
import com.springData.movies.services.ActorService;
import com.springData.movies.services.MovieService;



@Controller
public class Movies {
	
	private MovieService movieService;
	private ActorService actorService;
	
	public Movies(MovieService movieService,ActorService actorService) {
		this.movieService = movieService;
		this.actorService=actorService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("actress", new Actor());
		model.addAttribute("movies", movieService.all());
		model.addAttribute("actresses", this.actorService.all());
		return "index";
	}
	
	@PostMapping("movies")
	public String movies(@Valid @ModelAttribute("movie") Movie movie, BindingResult result,Model model) {
//		System.out.println(movie.getTitle());
		if (result.hasErrors()) {
			model.addAttribute("movies", movieService.all());
			List<ObjectError> errors = result.getAllErrors();
			for (int i = 0; i<errors.size();i++) {
				System.out.println(errors.get(i).getDefaultMessage());// Can set errors to flash message spring system 
			}
			return "index";
		}
		movieService.create(movie);
		return "redirect:/";
	}
	
	@RequestMapping("movie/{id}")
	public String actor(@PathVariable Long id, Model model) {
		model.addAttribute("movie", this.movieService.findById(id));
		return "movie";
	}
	
	@PostMapping("/movie/{id}/update")
	public String update(@Valid @ModelAttribute("actress") Movie movie, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "movie";
		}
		this.movieService.update(movie);
		return "redirect:/";
	}
	
	@PostMapping("/movie/{id}/delete")
	public String delete(@PathVariable Long id) {
		this.movieService.delete(id);
		return "redirect:/";
	}
}	

