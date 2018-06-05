package com.springData.dojoOverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springData.dojoOverflow.models.Question;
import com.springData.dojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository=questionRepository;
	}
	
	public Question create(Question question) {
		return this.questionRepository.save(question);
	}
	
	public ArrayList<Question>all(){
		return (ArrayList<Question>) questionRepository.findAll();
	}
	
	public Question findById(Long id) {
		return this.questionRepository.findOne(id);
	}
	
	public Question update(Question question) {
		return this.questionRepository.save(question);
	}
	
	public void delete(Long id) {
		this.questionRepository.delete(id);
		
	}

}
