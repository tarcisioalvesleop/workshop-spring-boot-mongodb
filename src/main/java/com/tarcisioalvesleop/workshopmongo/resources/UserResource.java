package com.tarcisioalvesleop.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarcisioalvesleop.workshopmongo.domain.User;
import com.tarcisioalvesleop.workshopmongo.dto.UserDTO;
import com.tarcisioalvesleop.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)//@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){				
		List<User> list = service.findAll();
		//convertendo list<User> para list<UserDTO>
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
