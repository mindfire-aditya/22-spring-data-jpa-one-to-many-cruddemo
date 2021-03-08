package com.webdev.springboot.cruddemo.service;

import java.util.List;

import com.webdev.springboot.cruddemo.entity.Dependent;

	public interface DependentService {
	
		public List<Dependent> findAll();
		
		public Dependent findById(int id);
		
		void save(Dependent dependent);
		
		void deleteById(int id);
}
