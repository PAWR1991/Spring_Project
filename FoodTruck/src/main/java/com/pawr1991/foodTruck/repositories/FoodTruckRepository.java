package com.pawr1991.foodTruck.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pawr1991.foodTruck.models.FoodTruck;

public interface FoodTruckRepository extends CrudRepository<FoodTruck, Long> {
	@Query(value="SELECT * FROM foodtrucks ORDER BY avg_rating DESC;", nativeQuery=true)
	List<FoodTruck> findAll();
}
