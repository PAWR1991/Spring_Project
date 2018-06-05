package com.pawr1991.foodTruck.services;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pawr1991.foodTruck.models.User;
import com.pawr1991.foodTruck.repositories.UserRepository;

@Service
public class UserService {
	private BCryptPasswordEncoder bcrypt;
	private UserRepository repo;
	
	public UserService(UserRepository repo, BCryptPasswordEncoder bcrypt) {
		this.repo=repo;
		this.bcrypt=bcrypt;
	}
	
	public User create(Map<String, String> body) {
		return this.repo.save(new User(
				body.get("username"),
				body.get("email"),
				bcrypt.encode(body.get("password"))
				));
	}
	
	public ArrayList<User>all(){
		return (ArrayList<User>) repo.findAll();
	}
	
	public User findById(Long id) {
		return this.repo.findOne(id);
	}
	
	public User findByEmail(String email) {
		return this.repo.findByEmail(email);
	}
	
	public User update(User model) {
		return this.repo.save(model);
	}
	
	public void delete(Long id) {
		this.repo.delete(id);
		
	}
}
