package com.gelli.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gelli.workshopmongo.domain.Post;
import com.gelli.workshopmongo.repository.PostRepository;
import com.gelli.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository rep;
	
	  public Post findById(String id) {
		Optional<Post> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	
}
