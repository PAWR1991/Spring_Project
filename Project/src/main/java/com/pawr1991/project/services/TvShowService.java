package com.pawr1991.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pawr1991.project.models.TvShow;
import com.pawr1991.project.repositories.TvShowRepository;

@Service
public class TvShowService {
private TvShowRepository repo;
	
	public TvShowService(TvShowRepository repo) {
		this.repo=repo;
	}
	
	public TvShow create(TvShow model) {
		return this.repo.save(model);
	}
	
	public List<TvShow>findAll(){
		return (List<TvShow>) repo.findAll();
	}
	
	public TvShow findById(Long id) {
		return this.repo.findOne(id);
	}
	
	public List<TvShow> findAllByTitle(String title) {
		return this.repo.findAllByTitle(title);
	}
	
	public TvShow findByNetwork(String network) {
		return this.repo.findByNetwork(network);
	}
	
	public TvShow update(TvShow model) {
		return this.repo.save(model);
	}
	
	public void delete(Long id) {
		this.repo.delete(id);
		
	}
}
