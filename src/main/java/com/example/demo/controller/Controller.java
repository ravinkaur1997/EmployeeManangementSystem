package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpRepository;
import com.example.demo.model.Employee;
import com.example.demo.model.User;
import com.example.demo.service.EmpService;

@RestController
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	public EmpRepository repository;
	
	@Autowired
	public EmpService service;
	
	@PostMapping("/register")
    public String register(@RequestBody Employee emp) {
        
		return service.postEmp(emp);
    }
    
    @GetMapping("/getAllEmployees")
    public List<Employee> findAllEmployees() {
        return service.getAllEmployees();
    }
    
    @GetMapping("/getAllEmployeesInPage")
    public Map<String, Object> getAllEmployeesInPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
    		@RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
    		@RequestParam(name = "sortBy", defaultValue = "id") String sortBy ) {
        return service.getAllEmpInPage(pageNo, pageSize, sortBy);
    }
    
    @PostMapping("/login")
    public Employee empLogin(@RequestBody User user) {
		 return service.validateUser(user.getUsername(), user.getPassword());
		
    }
     
    @PutMapping("/update")
    public String updateEmp(@RequestBody Employee emp) {
    	return service.putEmp(emp);
    }
    
    @GetMapping("/findEmpByMail/{email}")
    public List<Employee> findUser(@PathVariable String email) {
  
    	return service.getByMail(email);
    }
    
    @GetMapping("/findByFirstnamePrefix")
    public List<Employee> findEmployee(@RequestParam(name = "firstname") String firstname) {
    	return service.getByFirstname(firstname);
    }
    
    @GetMapping("/getEmpByExperience")
    public List<Employee> getEmployeeByExperience(@RequestParam(name = "experience") int experience) {
    	return service.getEmployeeByExperience(experience);
    }
    
    @DeleteMapping("/delete/{id}")
    public List<Employee> cancelRegistration(@PathVariable int id) {
    	return service.deleteById(id);    
    }
    
}
