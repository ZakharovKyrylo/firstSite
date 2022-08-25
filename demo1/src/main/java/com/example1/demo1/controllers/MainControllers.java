package com.example1.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example1.demo1.models.Admin;

@Controller
public class MainControllers {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Главная страница");			
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {		
		return "about";
	}
	
	@GetMapping("/admin1368")
	public String admin(Model model) {				
		return "admin";
	}
	
	@PostMapping("/admin1368")
	public String blogPostAdd(@RequestParam String password ,Model model) {		
		Admin admin = new Admin(password);
		if(admin.getPass()) {			
			return "blog-add";
		}
		else {			
			return "redirect:/";
		}		
	}	
}

