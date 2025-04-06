package com.raul.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.webapp.springbootweb.controllers.models.User;
import com.raul.curso.springboot.webapp.springbootweb.controllers.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@GetMapping("/details-map")
	public Map<String, Object> detailsMap() {
		User user = new User("Raul", "Gonzalez");
		Map<String, Object> body = new HashMap<>();
		body.put("title", "Hola Mundo Spring Boot - Map");
		body.put("user", user);

		return body;
	}

	@GetMapping("/details")
	public UserDto details() {
		UserDto userDto = new UserDto();
		User user = new User("Raul", "Gonzalez");
		userDto.setUser(user);
		userDto.setTitle("Hola Mundo Spring Boot - dto");
		
		return userDto;
	}

	@GetMapping("/details-list")
	public List<User> detailsList() {

		User user = new User("Raul", "Gonzalez");
		User user2 = new User("Juan", "Gonzalez");
		User user3 = new User("Ricardo", "Gonzalez");
	
		//List<User> users= new ArrayList<>();
		//users.add(user);
		//users.add(user2);
		//users.add(user3);

		// Esto seria la forma abreviada
		List<User> users= Arrays.asList(user, user2, user3);

		
		return users;
	}
}
