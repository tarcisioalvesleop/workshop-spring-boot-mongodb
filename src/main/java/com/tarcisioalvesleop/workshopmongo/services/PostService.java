package com.tarcisioalvesleop.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarcisioalvesleop.workshopmongo.domain.Post;
import com.tarcisioalvesleop.workshopmongo.repository.PostRepository;
import com.tarcisioalvesleop.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado."));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
		//return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//acrescentando um dia a data em milisegundos
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}

