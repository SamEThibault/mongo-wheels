package com.ms.mongowheels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ms.mongowheels.beans.Car;
import com.ms.mongowheels.repositories.CarRepository;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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
	
	@GetMapping("/fuel")
	public String fuel() {
		return "fuel";
	}
	
	@GetMapping("/engine")
	public String engine(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
		return "engine";
	}
	
	@GetMapping("/body")
	public String body() {
		return "body";
	}

	@PostMapping("/addCar")
	public String addCar(Model model, @ModelAttribute Car car) {
		car.setId(null);
		carRepo.save(car);
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
		return "home";
	}

	// in progress, not fully functional
	@RequestMapping("/getCars")
	public String getCars(Model model, @RequestParam("make") String make)
	{
//		ModelAndView mv = new ModelAndView();
		// for each car returned from the get request, add to modelView object as "car" attribute
//		carRepo.findCarsByMake(make).forEach(car -> {
//			mv.addObject("car", car);
//		});

		model.addAttribute("carList", carRepo.findCarsByMake(make));
		return "search";
	}


}
