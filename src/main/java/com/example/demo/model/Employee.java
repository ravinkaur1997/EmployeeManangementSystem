package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document
public class Employee {
	
	@Id
    private int id;
    private String firstname;
    private String lastname;
	private String password;
    private LocalDate dob;
    private long mobileno;
    private String email;
    private int experience;
    private String domain;
    
    public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getPassword() {
		return password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public long getMobileno() {
		return mobileno;
	}
	public String getEmail() {
		return email;
	}
	public int getExperience() {
		return experience;
	}
	public String getDomain() {
		return domain;
	}
	
}
