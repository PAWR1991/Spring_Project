package com.pawr1991.foodTruck.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pawr1991.foodTruck.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);

}
