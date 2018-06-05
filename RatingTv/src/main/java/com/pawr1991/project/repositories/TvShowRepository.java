package com.pawr1991.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pawr1991.project.models.TvShow;

public interface TvShowRepository extends CrudRepository<TvShow, Long> {
	@Query(value="SELECT * FROM tvshows ORDER BY avg_rating DESC;", nativeQuery=true)
	List<TvShow> findAll();
	
	List<TvShow> findAllByTitle(String title);
	TvShow findByNetwork(String network);
	
	
}
