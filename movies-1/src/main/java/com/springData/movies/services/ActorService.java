package com.springData.movies.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springData.movies.models.Actor;
import com.springData.movies.repositories.ActressRepository;

@Service
public class ActorService {
	private ActressRepository actressRepository;
	
	public ActorService(ActressRepository actressRepository) {
		this.actressRepository=actressRepository;
	}
	
	public Actor create(Actor actress) {
		return this.actressRepository.save(actress);
	}
	
	public ArrayList<Actor>all(){
		return (ArrayList<Actor>) actressRepository.findAll();
	}
	
	public Actor findById(Long id) {
		return this.actressRepository.findOne(id);
	}
	
	public Actor update(Actor actress) {
		return this.actressRepository.save(actress);
	}
	
	public void delete(Long id) {
		this.actressRepository.delete(id);
		
	}


}
