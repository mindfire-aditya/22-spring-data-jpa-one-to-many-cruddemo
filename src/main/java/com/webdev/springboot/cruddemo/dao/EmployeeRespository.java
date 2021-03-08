package com.webdev.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.springboot.cruddemo.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
