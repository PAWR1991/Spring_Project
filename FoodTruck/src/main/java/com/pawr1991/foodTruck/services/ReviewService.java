package com.pawr1991.foodTruck.services;

import org.springframework.stereotype.Service;

import com.pawr1991.foodTruck.models.Review;
import com.pawr1991.foodTruck.repositories.ReviewRepositiory;


@Service
public class ReviewService {
	
	private ReviewRepositiory repo;
	
	public ReviewService(ReviewRepositiory repo) {
		this.repo=repo;
	}
	
	public Review create(Review model) {
		return repo.save(model);
	}
	
}
