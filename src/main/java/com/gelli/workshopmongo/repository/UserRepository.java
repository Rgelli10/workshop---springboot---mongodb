package com.gelli.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gelli.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository <User, String>{
	
	

}
