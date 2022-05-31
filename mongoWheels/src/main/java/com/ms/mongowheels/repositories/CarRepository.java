package com.ms.mongowheels.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongowheels.beans.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    // returns list of car objects which "make" fields match the make parameter
    List<Car> findCarsByMake(String make);
}
