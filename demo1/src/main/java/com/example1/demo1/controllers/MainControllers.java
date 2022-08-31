package com.example1.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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

}

