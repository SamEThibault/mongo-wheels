package com.ms.mongowheels.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongowheels.beans.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
