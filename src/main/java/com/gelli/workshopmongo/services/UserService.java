package com.gelli.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gelli.workshopmongo.domain.User;
import com.gelli.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;
	
	public List<User> findAll(){
		return rep.findAll();
	}

}
