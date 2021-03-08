package com.webdev.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdev.springboot.cruddemo.entity.Dependent;
import com.webdev.springboot.cruddemo.entity.Employee;
import com.webdev.springboot.cruddemo.service.DependentService;
import com.webdev.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class DependentRestController {

	private DependentService dependentService;
	private EmployeeService employeeService;

	@Autowired
	DependentRestController(DependentService dependentService,EmployeeService employeeService) {
		this.dependentService = dependentService;
		this.employeeService = employeeService;
		
	}

	
	@GetMapping("/dependents")
	public List<Dependent> findAll() {
		return this.dependentService.findAll();
	}
	
	@PostMapping("/dependents/{empId}")
	public void addDependent(@RequestBody Dependent dependent, @PathVariable int empId) {
		Employee employee =  this.employeeService.findById(empId);
		
		if(employee==null) {
			throw new RuntimeException("Employee not found");
		}
		
		else {
			dependent.setEmployee(employee);
			this.dependentService.save(dependent);
		}
	}
}
