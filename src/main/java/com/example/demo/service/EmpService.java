package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Employee;

public interface EmpService {
	
	public String postEmp(Employee emp);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> getByMail(String email);
	
	public List<Employee> deleteById(int id);

	public String putEmp(Employee emp);

	public Employee validateUser(String username, String password);

	public Map<String, Object> getAllEmpInPage(int pageNo, int pageSize, String sortBy);

	public List<Employee> getByFirstname(String firstname);

	public List<Employee> getEmployeeByExperience(int experience);
}
