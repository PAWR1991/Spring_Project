package com.springData.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springData.dojoOverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

}
