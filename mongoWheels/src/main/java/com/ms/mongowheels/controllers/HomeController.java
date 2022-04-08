package com.ms.mongowheels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/explore")
	public String explore() {
		return "explore.html";
	}
	
	@GetMapping("/favorites")
	public String favorites() {
		return "favorites.html";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search.html";
	}
}
