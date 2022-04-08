package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongowheels.beans.Identification;

public interface IdentificationRepository extends MongoRepository<Identification, String> {

}
