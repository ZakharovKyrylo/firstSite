package com.example1.demo1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example1.demo1.entety.BlogEntety;
import com.example1.demo1.repo.PostRepository;

@Controller
public class BlogControllers {	
	
	@Autowired
	private PostRepository postRepository;
	BlogEntety blogEntety = new BlogEntety();
	
	@GetMapping("/blog")
	public String blogeMain(Model model) {	
		System.out.println("BlogControllers blogeMain start");
		blogEntety.blogeMain(model , postRepository);
		return "blog-main";
	}	

		
	@GetMapping("/blog/{id}")
	public String blogFull(@PathVariable(value = "id") long id, Model model) {	
		blogEntety.blogFull(id ,model ,postRepository);
		
		if(blogEntety.getPostEmpty())
		{
			return "blog-main";
		}
		return "blog-details";
	}
}