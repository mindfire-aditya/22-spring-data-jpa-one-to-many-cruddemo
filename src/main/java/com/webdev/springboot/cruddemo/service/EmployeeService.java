package com.webdev.springboot.cruddemo.service;

import java.util.List;

import com.webdev.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	void save(Employee employee);
	
	void deleteById(int id);
	
	
}
