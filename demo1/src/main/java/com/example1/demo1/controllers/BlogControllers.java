package com.example1.demo1.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example1.demo1.models.Post;
import com.example1.demo1.repo.PostRepository;


@Controller
public class BlogControllers {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/blog")
	public String blogeMain(Model model) {		
		Iterable<Post> posts = postRepository.findAll();		
		model.addAttribute("posts", posts);
		return "blog-main";
	}	

	@PostMapping("/blog/add")
	public String blogPostAdd(@RequestParam String title , @RequestParam String anons , @RequestParam String full_text ,Model model) {
		System.out.println("/blog/add");
		Post post = new Post(title, anons , full_text);	
		postRepository.save(post);	
		//post = postRepository.findById(post.getId()).orElseThrow();		
		if( title.isEmpty() && anons.isEmpty() && full_text.isEmpty()) {
			System.out.println("isEmpty = true");
			return  "redirect:/blog/" + post.getId();
		}
		else {
			System.out.println("isEmpty = false");
			return  "redirect:/blog/" + post.getId() + "/edit";
		}
	} 	
		
	@GetMapping("/blog/{id}")
	public String blogFull(@PathVariable(value = "id") long id, Model model) {		
		if(!postRepository.existsById(id)) {
			return  "redirect:/blog";
		}
		Post myPost = postRepository.findById(id).orElseThrow();

		int views = myPost.getViews()+1;
		myPost.setViews(views);
		postRepository.save(myPost);
		model.addAttribute("posts", myPost);

		return "blog-details";
	}
	
	@GetMapping("/blog/{id}/edit")
	public String blogEdit(@PathVariable(value = "id") long id, Model model) {		
		System.out.println("blogEdit");
		if(!postRepository.existsById(id)) {
			return  "redirect:/blog";
		}
		Optional<Post> post = postRepository.findById(id);
		System.out.println(post);
		model.addAttribute("posts", post);
		return "blog-edit";
	}	
	
	@PostMapping("/blog/{id}/edit")
	public String blogPostApdate(@PathVariable(value = "id") long id, @RequestParam String title , @RequestParam String anons , @RequestParam String full_text ,Model model) {	
		Post post = postRepository.findById(id).orElseThrow();
		post.setAnons(anons);
		post.setFull_text(full_text);
		post.setTitle(title);
		postRepository.save(post); 
		return  "redirect:/blog";
	} 
	
	@GetMapping("/blog/{id}/remove")
	public String blogRemove(@PathVariable(value = "id") long id, Model model) {		
		if(!postRepository.existsById(id)) {
			return  "redirect:/blog";
		}
		postRepository.deleteById(id);		
		return "redirect:/blog";
	}
}