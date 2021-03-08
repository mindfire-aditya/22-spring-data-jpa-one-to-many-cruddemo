package com.webdev.springboot.cruddemo.rest;

import java.util.List;
import com.webdev.springboot.cruddemo.entity.Employee;
import com.webdev.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.webdev.springboot.cruddemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// expose /employees and return list of employees

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee id not found -" + employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not found for id-"+id);
		}
		
		employeeService.deleteById(id);
		
		return "Deleted the employee"+employee;
	}
	
	
}
