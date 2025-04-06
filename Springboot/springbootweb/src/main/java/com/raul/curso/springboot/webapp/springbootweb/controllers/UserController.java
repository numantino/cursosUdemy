package com.raul.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.raul.curso.springboot.webapp.springbootweb.controllers.models.User;

@Controller
public class UserController {

	@GetMapping("/details1")
	public String details1(Model model) {
		// Tambien se puede usar Map<String, Object> pero es mas limpio Model
		model.addAttribute("title", "Hola Mundo Spring Boot");
		model.addAttribute("name", "Raul");
		model.addAttribute("lastname", "Gonzalez");
		return "details1";
	}

	@GetMapping("/details")
	public String details(Model model) {
		User user = new User("Raul", "Gonzalez");
		user.setEmail("raul@correo.com");
		model.addAttribute("title", "Hola Mundo Spring Boot");
		model.addAttribute("user", user);
		return "details";
	}

	@GetMapping("/list")
	public String list(Model model) {
		// Esta es una forma menos limpia
		// model.addAttribute("users", users);
		model.addAttribute("title", "Listado de usuarios");
		return "list";
	}

	// Con esto pasamos datos comunes a la vista
	@ModelAttribute("users")
	public List<User> userModel(){
		return Arrays.asList(
			new User("pepa", "Gonzalez"),
			new User("Raul", "Tarancon", "raul@correo.com"),
			new User("Ricardo", "Gonzalez")
			);
	}
}
