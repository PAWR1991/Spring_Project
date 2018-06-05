package com.pawr1991.loginRegistration.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.pawr1991.loginRegistration.models.User;
import com.pawr1991.loginRegistration.services.UserService;

@Component
public class UserValidator {
	private UserService userService;
	private BCryptPasswordEncoder bcrypt;
	
	
	public UserValidator(UserService userService,BCryptPasswordEncoder bcrypt) {
		this.userService=userService;
		this.bcrypt=bcrypt;
	}
	
	public static Pattern EMAIL_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]+", Pattern.CASE_INSENSITIVE);
	
	public HashMap<String, Object> registerV(Map<String,String> body){
		System.out.println("I'm in the validator");
		HashMap<String, Object> results = new HashMap<String,Object>();
		
//		System.out.println(body.get("username"));
//		System.out.println(body.get("email"));
//		System.out.println(body.get("password"));
//		System.out.println(body.get("confirm"));
		if(body.get("username").length() < 3) {
			results.put("username", "Username must be 3 characters or more");
			
		}
		if(body.get("email").length() < 1) {
			results.put("email", "Email is required!!!");
		}
		else if (!EMAIL_REGEX.matcher(body.get("email")).matches()) {
			results.put("email", "Invalid Email!!!");
		}
		else if (this.userService.findByEmail(body.get("email")) != null){
			results.put("email", "Email already in used!");
		}
		
		if(body.get("password").length() < 8) {
			results.put("password", "Password must be 8 characters or more");
		}
		else if (!body.get("password").equals(body.get("confirm"))) {
			results.put("confirm", "Confirm Password must match Password");
		}
		
		results.put("valid", results.size() == 0); // this gives me a true or false value
		
		return results;
	}
	
	public User login(Map<String, String> body) {
		Boolean valid = true;
		User user = new User();
		
		if(body.get("email").length() < 1) {
			valid = false;
		}
		else if (!EMAIL_REGEX.matcher(body.get("email")).matches()) {
			valid = false;
		}
		else {
			user=this.userService.findByEmail(body.get("email"));
			if(user == null) {
				valid = false;
			}
		}
		
		if(body.get("password").length() < 8) {
			valid = false;
		}else {
			if(valid) {
				if(!bcrypt.matches(body.get("password"), user.getPassword())) {
					valid = false;
				}
			}
		}
		
		return valid ? user : null;
				
	}
}
