package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.ms.mongowheels.beans.Dimensions;

public interface DimensionsRepository extends MongoRepository<Dimensions, String> {

}
