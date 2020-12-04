package com.onlyxcodes.mvcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlyxcodes.mvcapp.model.Employee;
import com.onlyxcodes.mvcapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> listAll(){
		
		return repository.findAll();
	}
	
	public void create(Employee employee) {
		
		repository.save(employee);
	}
	
	public Employee updateid(Long id) {
		
		return repository.findById(id).get();
	}
	
	public void delete(Long id) {
		
		repository.deleteById(id);
	}

}
