package com.example1.demo1.models;

import com.example1.demo1.controllers.AdminControllers;

public class Admin {	

	private final String PASS = "myPass1368";
	private boolean checkPass = false;
	
	public  void checkPass(String password) {
		// TODO Auto-generated constructor stub
		if(this.PASS.equals(password)) {
			checkPass = true;
			}
		else {	
			checkPass = false;	
			}
	}	
	
	public boolean getCheckPass() {
		return checkPass;
	}

}
