package com.tarcisioalvesleop.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tarcisioalvesleop.workshopmongo.domain.User;
import com.tarcisioalvesleop.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//deletando a collection
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brrown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		//salvando o banco
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
	}
	

}
