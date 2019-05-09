package com.gelli.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gelli.workshopmongo.domain.Post;
import com.gelli.workshopmongo.domain.User;
import com.gelli.workshopmongo.dto.AuthorDTO;
import com.gelli.workshopmongo.repository.PostRepository;
import com.gelli.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
	
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para SP, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"),  "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		Post post3 = new Post(null, sdf.parse("05/04/2019"), "Bom dia", "Boa pra nois", new AuthorDTO(alex));
	
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		maria.getPost().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		alex.getPost().addAll(Arrays.asList(post3));
		userRepository.save(alex);
	}
	
	

}
