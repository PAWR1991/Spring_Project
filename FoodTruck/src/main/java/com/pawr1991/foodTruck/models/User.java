package com.pawr1991.foodTruck.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=2, message = "Email must be 2 charactes or longer")
	private String username;
	@Size(min=2, message = "Email must be 2 charactes or longer")
	private String email;
	@Size(min=8, message = "Password must be 8 charactes or longer")
	private String password;
	
	@Transient
	private String confirm;
	
	private Date createdAt;
	private Date updatedAt;
	
	//One user can create many Foodtrucks
	@OneToMany(mappedBy="op", fetch = FetchType.LAZY)
	private List<FoodTruck> trucks;
	
	@OneToMany(mappedBy="reviewer", fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	
	
	public User() {
		
	}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public List<FoodTruck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<FoodTruck> trucks) {
		this.trucks = trucks;
	}

	@PrePersist
	protected void onCreate() {
		this.setCreatedAt(new Date());
		this.setUpdatedAt(new Date());
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.setUpdatedAt(new Date());
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

}
