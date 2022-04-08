package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongowheels.beans.Engine;

public interface EngineRepository extends MongoRepository<Engine, String> {

}
