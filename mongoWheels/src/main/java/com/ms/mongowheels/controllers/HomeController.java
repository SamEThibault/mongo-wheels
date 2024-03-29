package com.ms.mongowheels.controllers;

import javax.servlet.http.HttpSession;

import java.security.Principal;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.mongowheels.beans.Car;
import com.ms.mongowheels.beans.Post;
import com.ms.mongowheels.beans.User;
import com.ms.mongowheels.emails.EmailServiceImpl;
import com.ms.mongowheels.repositories.CarRepository;
import com.ms.mongowheels.repositories.PostRepository;
import com.ms.mongowheels.repositories.UserRepository;






@Controller
public class HomeController {

	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired 
	@Lazy
	private UserRepository userRepo;
	
	@Autowired
	private EmailServiceImpl esi;
	
	@GetMapping("/")
	public String home(HttpSession session, Model model, Authentication authentication) {
		String message;
	if (session.isNew()) {
		message = "Welcome!";
	}
	else {
		message = "Welcome back!";
		
	}
//		model.addAttribute("mymessage", message);
//		
//		try {
//			esi.sentMailWithThymeleaf("alfjtbs@gmail.com", "Test", "test", "test", "test");
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}
//		
		
		return "home"; 
	}
	
	
	@GetMapping("/explore")
	public String getCarsByHp(Model model)
	{
		model.addAttribute("carList", carRepo.findAllByHpEquals(500));
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

	@GetMapping("/nav")
	public String nav(){ return "nav";}
	
	@GetMapping("/fuel")
	public String fuel(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
		return "fuel";
	}
	
	@GetMapping("/engine")
	public String engine(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
		return "engine";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
		return "text";
	}
	
	
	
	@GetMapping("/body")
	public String body(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carList", carRepo.findAll());
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
	
	@GetMapping("/community")
	public String community(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("postList", postRepo.findAll());
		return "community";
	}
	
	@PostMapping("/addPost")
	public String addPost(Model model, @ModelAttribute Post post) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		post.setId(null);
		post.setUsername(auth.getName());
		postRepo.save(post);
		model.addAttribute("post", new Post());
		model.addAttribute("postList", postRepo.findAll());
		return "redirect:/community";
	}
	
    @GetMapping("/deletePost/{id}")
    public String deletePost(Model model, @PathVariable("id") String id) {
        postRepo.deleteById(id);
        model.addAttribute("Post", new Post()); 
        model.addAttribute("postList", postRepo.findAll()); 
        return "redirect:/community";
    }
    
    @GetMapping("/editPost/{id}")
    public String editPost(Model model, @PathVariable String id) {
        model.addAttribute("post", postRepo.findById(id).get());
        
        return "editPost";
    }
    
    @PostMapping("/editPost")
    public String updatePostForm(Model model, @ModelAttribute Post post) {
        postRepo.save(post);
        
        model.addAttribute("post", new Post());
        model.addAttribute("postList", postRepo.findAll()); 
        return "redirect:/community";
    }
	
	
	
	
	//--------------------------------Matt's testing zone----------------------

	    
	
	//--------------------------------------------------------------------------
	

	@RequestMapping("/getCars")
	public String getCars(Model model, @RequestParam("make") String make)
	{
		model.addAttribute("carList", carRepo.findCarsByMake(make));
		return "search";
	}
}
