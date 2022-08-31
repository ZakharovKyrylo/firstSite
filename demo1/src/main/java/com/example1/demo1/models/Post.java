package com.example1.demo1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String title,anons,full_text;
	private int views;
	
	public Post(){		
	}

	public Post(String title, String anons, String full_text) {
		this.title = title;
		this.anons = anons;
		this.full_text = full_text;
		this.views = 0;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnons() {
		return anons;
	}
	public void setAnons(String anons) {
		this.anons = anons;
	}	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getFull_text() {
		return full_text;
	}
	public void setFull_text(String full_text) {
		this.full_text = full_text;
	}	
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", anons=" + anons + ", full_text=" + full_text + ", views="
				+ views + "]";
	}

}
