package com.webdev.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.springboot.cruddemo.entity.Dependent;

public interface DependentRespository extends JpaRepository<Dependent, Integer> {

}
