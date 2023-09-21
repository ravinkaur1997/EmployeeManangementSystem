package com.example.demo.model;

import lombok.Data;

@Data
public class User {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
