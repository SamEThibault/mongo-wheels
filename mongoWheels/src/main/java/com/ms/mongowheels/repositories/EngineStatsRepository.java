package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongowheels.beans.EngineStats;

public interface EngineStatsRepository extends MongoRepository<EngineStats, String> {

}
