package com.tarcisioalvesleop.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarcisioalvesleop.workshopmongo.domain.User;
import com.tarcisioalvesleop.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)//@GetMapping
	public ResponseEntity<List<User>> findAll(){				
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
