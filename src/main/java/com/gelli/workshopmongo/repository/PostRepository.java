package com.gelli.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gelli.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository <Post, String>{
	
}
