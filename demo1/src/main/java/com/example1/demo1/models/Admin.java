package com.example1.demo1.models;

public class Admin {	

	private final String password = "myPass1368";
	private boolean checkPass=false;
	
	public Admin(String password) {
		// TODO Auto-generated constructor stub
		if(this.password.equals(password)) {
			checkPass= true;
			}
		else {	
			checkPass = false;	
			}
	}
	
	public boolean getPass() {
		return checkPass;
	}

}
