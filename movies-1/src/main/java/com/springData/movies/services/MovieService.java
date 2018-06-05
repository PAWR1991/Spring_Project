package com.springData.movies.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springData.movies.models.Movie;
import com.springData.movies.repositories.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	public Movie findone(int id) {
		return movieRepository.findOne((long) id);
	}
	
	public Movie create(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public ArrayList<Movie> all(){
		return (ArrayList<Movie>) movieRepository.findAll();
	}
	
	public Movie findById(Long id) {
		return this.movieRepository.findOne(id);
	}
	
	public Movie update(Movie actress) {
		return this.movieRepository.save(actress);
	}
	
	public void delete(Long id) {
		this.movieRepository.delete(id);
		
	}
	
}
