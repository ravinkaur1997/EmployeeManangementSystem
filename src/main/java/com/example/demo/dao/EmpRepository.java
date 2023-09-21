package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmpRepository extends MongoRepository<Employee, Integer> {
	boolean existsByEmail(String email);

	List<Employee> findByFirstnameStartingWith(String firstname);
	
	@Query(value = "{'experience':{$gte:?0}}")
	List<Employee> findByExperience(int experience);

	Employee findByEmail(String username);

	List<Employee> getByEmail(String email);

}
