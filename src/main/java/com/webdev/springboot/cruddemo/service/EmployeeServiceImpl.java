package com.webdev.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdev.springboot.cruddemo.dao.EmployeeRespository;
import com.webdev.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRespository employeeRespository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
		this.employeeRespository = employeeRespository;
	}
	
	@Override
	public List<Employee> findAll() {
		return this.employeeRespository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = this.employeeRespository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Employee not founf");
		}
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		this.employeeRespository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		this.employeeRespository.deleteById(id);

	}

}
