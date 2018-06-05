package com.springData.movies.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springData.movies.models.Actor;
import com.springData.movies.models.Movie;
import com.springData.movies.services.ActorService;
import com.springData.movies.services.MovieService;

@Controller
public class Actors {
	private MovieService movieService;
	private ActorService actorService;
	
	public Actors(MovieService movieService,ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}
	
	@PostMapping("actors")
	public String actress(@Valid @ModelAttribute("actress") Actor actress, BindingResult result,Model model) {
		System.out.println(actress.getName());
		if(result.hasErrors()) {
			model.addAttribute("movie", new Movie());
			model.addAttribute("movies", movieService.all());
			return "index";
		}
		this.actorService.create(actress);
		return"redirect:/";
	}
	
	@RequestMapping("actor/{id}")
	public String actor(@PathVariable Long id, Model model) {
		model.addAttribute("actress", this.actorService.findById(id));
		return "actress";
	}
	
	@PostMapping("/actor/{id}/update")
	public String update(@Valid @ModelAttribute("actress") Actor actress, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "actress";
		}
		this.actorService.update(actress);
		return "redirect:/";
	}
	
	@PostMapping("/actor/{id}/delete")
	public String delete(@PathVariable Long id) {
		this.actorService.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("cast")
	public String cast(@RequestParam Long actor_id, @RequestParam Long movie_id) {
		Movie movie = this.movieService.findById(movie_id);
		Actor actor = this.actorService.findById(actor_id);
		System.out.println(movie.getTitle());
		System.out.println(actor.getName());
		List<Actor> actresses = movie.getActresses();
		actresses.add(actor);
		movie.setActresses(actresses);
		this.movieService.update(movie);
		return "redirect:/";
	}

}
