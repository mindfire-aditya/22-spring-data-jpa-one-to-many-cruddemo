package com.webdev.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdev.springboot.cruddemo.entity.Dependent;
import com.webdev.springboot.cruddemo.service.DependentService;
import com.webdev.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class DependentRestController {

	private DependentService dependentService;

	@Autowired
	DependentRestController(DependentService dependentService) {
		this.dependentService = dependentService;
		
	}

	
	@GetMapping("/dependents")
	public List<Dependent> findAll() {
		return this.dependentService.findAll();
	}
	
}
