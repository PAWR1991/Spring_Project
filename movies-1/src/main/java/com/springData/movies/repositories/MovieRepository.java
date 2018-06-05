package com.springData.movies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springData.movies.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
