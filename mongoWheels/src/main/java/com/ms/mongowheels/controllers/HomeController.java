package com.ms.mongowheels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.mongowheels.beans.Car;
import com.ms.mongowheels.repositories.CarRepository;





@Controller
public class HomeController {

	@Autowired
	private CarRepository carRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
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
	@PostMapping("/addCar")
	public String addCar(Model model, @ModelAttribute Car car) {
		car.setId(null);
		carRepo.save(car);
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
		return "home";
	}
}
