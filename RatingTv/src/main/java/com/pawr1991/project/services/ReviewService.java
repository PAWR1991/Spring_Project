package com.pawr1991.project.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.pawr1991.project.models.Review;
import com.pawr1991.project.repositories.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository repo;
	
	public ReviewService(ReviewRepository repo) {
		this.repo=repo;
	}
	
	public Review create(Review model) {
		return this.repo.save(model);
	}
	
	public ArrayList<Review>findAll(){
		return (ArrayList<Review>) repo.findAll();
	}
	
	public Review findById(Long id) {
		return this.repo.findOne(id);
	}
	
	public Review update(Review model) {
		return this.repo.save(model);
	}
	
	public void delete(Long id) {
		this.repo.delete(id);
		
	}
}
