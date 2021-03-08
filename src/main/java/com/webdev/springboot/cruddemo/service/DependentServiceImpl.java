package com.webdev.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdev.springboot.cruddemo.dao.DependentRespository;
import com.webdev.springboot.cruddemo.entity.Dependent;

@Service
public class DependentServiceImpl implements DependentService {

	@Autowired
	private DependentRespository dependentRepository;

	
	public DependentServiceImpl(DependentRespository dependentRepository) {
		this.dependentRepository = dependentRepository;
	}

	@Override
	public List<Dependent> findAll() {
		return this.dependentRepository.findAll();
	}

	@Override
	public Dependent findById(int id) {
		
		Optional<Dependent> result = this.dependentRepository.findById(id);
		
		Dependent dependent = null;
		
		if(result.isPresent()) {
			dependent = result.get();
		}else {
			throw new RuntimeException("Dependent not found");
		}
		
		return dependent;

	}

	@Override
	public void save(Dependent dependent) {
		this.dependentRepository.save(dependent);

	}

	@Override
	public void deleteById(int id) {
		this.dependentRepository.deleteById(id);;

	}

}
