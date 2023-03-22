package com.COMTRUE.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.COMTRUE.demo.entity.Employees;
import com.COMTRUE.demo.repository.EmployeesRepository;

@Service
public class EmployeesService {

	private boolean flag;

	@Autowired
	private EmployeesRepository repository;

	@Transactional
	public boolean add(Employees employees) {
		flag = true;
		List<Employees> employeesEntityList = repository.findAll();
		employeesEntityList.forEach(employeesEntity -> {
			if (employeesEntity.getId().equals(employees.getId())) {
				System.out.println(employeesEntity.getId() + "번 -> " + employees.getId());
				flag = false;
			}
		});
		if (flag) {
			repository.save(employees);
		}
		return flag;
	}

	@Transactional
	public Employees findById(String id) {
		String newId = "";
		if (id.length() == 1) {
			newId += "00" + id;
		} else if (id.length() == 2) {
			newId += "0" + id;
		} else {
			newId = id;
		}
		System.out.println(newId);
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
		Employees employeesEntity = this.findById(id);
		repository.deleteById(employeesEntity.getId());
		return true;
	}

	@Transactional
	public boolean update(String originId, Employees employees) {
		System.out.println(originId);
		System.out.println(employees);
		Employees employeesEntity = this.findById(originId);
		employeesEntity.setId(employees.getId());
		employeesEntity.setPosition(employees.getPosition());
		employeesEntity.setEmail(employees.getEmail());
		employeesEntity.setName(employees.getName());
		employeesEntity.setPhoneNumber(employees.getPhoneNumber());
		return true;
	}
}
