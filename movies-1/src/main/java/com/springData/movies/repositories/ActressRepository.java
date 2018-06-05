package com.springData.movies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springData.movies.models.Actor;

public interface ActressRepository extends CrudRepository<Actor, Long> {

}
