package com.ms.mongowheels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ms.mongowheels.beans.Dimensions;
import com.ms.mongowheels.repositories.CarRepository;



@Controller
public class HomeController {

	@Autowired
	private CarRepository dimensionRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("dimensions", new Dimensions());
		model.addAttribute("dimensionsList", dimensionRepo.findAll());
		return "home";
	}
	
	@GetMapping("/explore")
	public String explore() {
		return "explore";
	}
	
	@GetMapping("/favorites")
	public String favorites() {
		return "favorites";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search";
	}
}
