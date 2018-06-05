package com.pawr1991.foodTruck.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.pawr1991.foodTruck.models.FoodTruck;
import com.pawr1991.foodTruck.repositories.FoodTruckRepository;

@Service
public class FoodTruckService {
	private FoodTruckRepository repo;
	
	public FoodTruckService(FoodTruckRepository repo) {
		this.repo = repo;
	}
	
	public FoodTruck create(FoodTruck model) {
		return repo.save(model);
	}
	
	public FoodTruck update(FoodTruck model) {
		return repo.save(model);
		
	}
	
	public ArrayList<FoodTruck> findAll(){
		return (ArrayList<FoodTruck>)this.repo.findAll();
	}
	
	public FoodTruck findById(Long id) {
		return this.repo.findOne(id);
	}

}
