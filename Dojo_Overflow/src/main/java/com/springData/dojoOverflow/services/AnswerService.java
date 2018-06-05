package com.springData.dojoOverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springData.dojoOverflow.models.Answer;
import com.springData.dojoOverflow.repositories.AnswerRepository;


@Service
public class AnswerService {
private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository=answerRepository;
	}
	
	public Answer create(Answer answer) {
		return this.answerRepository.save(answer);
	}
	
	public ArrayList<Answer>all(){
		return (ArrayList<Answer>) answerRepository.findAll();
	}
	
	public Answer findById(Long id) {
		return this.answerRepository.findOne(id);
	}
	
	public Answer update(Answer answer) {
		return this.answerRepository.save(answer);
	}
	
	public void delete(Long id) {
		this.answerRepository.delete(id);
		
	}

}
