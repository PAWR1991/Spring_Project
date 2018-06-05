package com.springData.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springData.dojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
