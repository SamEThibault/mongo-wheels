package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ms.mongowheels.beans.Car;


public interface CarRepository extends MongoRepository<Car, String> {

}
