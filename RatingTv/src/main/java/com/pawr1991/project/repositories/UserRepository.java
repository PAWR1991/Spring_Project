package com.pawr1991.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pawr1991.project.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);

}
