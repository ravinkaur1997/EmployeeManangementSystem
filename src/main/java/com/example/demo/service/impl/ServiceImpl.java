package com.example.demo.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmpRepository;
import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;

@Service
public class ServiceImpl implements EmpService{
	@Autowired
	public EmpRepository repository;

	@Override
	public String postEmp(Employee emp) {

		if (repository.existsByEmail(emp.getEmail())) {
			return "Employee with this mailid: " + emp.getEmail() + " already exist";
		}
		else if(repository.existsById(emp.getId())) {
			return "Employee with this id: " + emp.getId() + " already exist";
		}
		else {
			repository.save(emp);
			return "Hi " + emp.getFirstname() + " your Registration process successfully completed";
		}

	}

	@Override
	public List<Employee> getAllEmployees() {

		return repository.findAll(Sort.by(Sort.Direction.ASC, "email"));
	}

	@Override
	public List<Employee> getByMail(String email) {
		if (repository.existsByEmail(email))
			return repository.getByEmail(email);
		else
			return null;
	}

	@Override
	public List<Employee> deleteById(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	@Override
	public String putEmp(Employee emp) {

		if (repository.existsById(emp.getId())) {
			//Query q = Query.query(Criteria.where("email").is(emp.getEmail()));
			repository.save(emp);
			return "Hi " + emp.getFirstname() + " your profile details successfully updated";
		} else
			return "Employee details not Found";
	}

	@Override
	public Employee validateUser(String username, String password) {

		Employee emp = repository.findByEmail(username);
		if (emp!=null && emp.getPassword().equals(password)) {
			return emp;
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getByFirstname(String firstname) {
		return repository.findByFirstnameStartingWith(firstname);
	}

	@Override
	public List<Employee> getEmployeeByExperience(int experience) {
		return repository.findByExperience(experience);
	}
	
	@Override
	public Map<String, Object> getAllEmpInPage(int pageNo, int pageSize, String sortBy) {
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		Sort sort = Sort.by(sortBy);
		PageRequest page = PageRequest.of(pageNo, pageSize, sort);
		Page<Employee> employeesPage = repository.findAll(page);
		response.put("data", employeesPage.getContent());
		response.put("Total Number of pages", employeesPage.getTotalPages());
		response.put("current page number", employeesPage.getNumber());
		response.put("Total Number of employees", employeesPage.getTotalElements());
		return response;
	}
}
