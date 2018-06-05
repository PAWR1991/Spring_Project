package com.springData.dojoOverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springData.dojoOverflow.models.Tag;
import com.springData.dojoOverflow.repositories.TagRepository;

@Service
public class TagService {
private TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository=tagRepository;
	}
	
	public Tag create(Tag tag) {
		return this.tagRepository.save(tag);
	}
	
	public ArrayList<Tag>all(){
		return (ArrayList<Tag>) tagRepository.findAll();
	}
	
	public Tag findById(Long id) {
		return this.tagRepository.findOne(id);
	}
	
	public Tag update(Tag tag) {
		return this.tagRepository.save(tag);
	}
	
	public void delete(Long id) {
		this.tagRepository.delete(id);
		
	}

}
