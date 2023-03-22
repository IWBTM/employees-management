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

	public Employees findById(String id) {
		String newId = "";
		if (id.length() == 1) {
			newId += "00" + id;
		} else if (id.length() == 2) {
			newId += "0" + id;
		} else {
			newId = id;
		}
		return repository.findById(newId).orElseThrow(() -> {
			return new IllegalArgumentException("찾으시는 직원이 존재하지 않습니다.");
		});
	}

	@Transactional
	public List<Employees> findAll() {
		return repository.findAll();
	}

	@Transactional
	public List<Employees> findByCategorySearch(String whatSearch, String q) {
		return repository.findByCategorySearch(whatSearch, q);
	}

	@Transactional
	public boolean delete(String id) {
		Employees employeesEntity = findById(id);
		repository.deleteById(employeesEntity.getId());
		return true;
	}
}
