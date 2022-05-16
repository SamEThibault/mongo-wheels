package com.ms.mongowheels.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ms.mongowheels.beans.Car;
import com.ms.mongowheels.beans.Dimensions;


public interface CarRepository extends MongoRepository<Car, String> {

	
	@Query(value="{}", fields = "{'info':1}")
	public List<Dimensions> getDimensions();


	
	
}
