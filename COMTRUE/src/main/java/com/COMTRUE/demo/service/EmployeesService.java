package com.COMTRUE.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.COMTRUE.demo.entity.Employees;
import com.COMTRUE.demo.repository.EmployeesRepository;

@Service
public class EmployeesService {

	@Autowired
	private EmployeesRepository repository;

	@Transactional
	public boolean add(Employees employees) {
		repository.save(employees);
		return true;
	}

	@Transactional
	public List<Employees> findAll() {
		return repository.findAll();
	}

	@Transactional
	public List<Employees> findByCategorySearch(String whatSearch, String q) {
		return repository.findByCategorySearch(whatSearch, q);
	}
}
