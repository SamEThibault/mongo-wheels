package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongowheels.beans.FuelInfo;

public interface FuelInfoRepository extends MongoRepository<FuelInfo, String> {

}
