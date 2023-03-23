package com.COMTRUE.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.COMTRUE.demo.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, String> {

	@Query(value = " SELECT * FROM employees "
								+ " WHERE ?1 = ?2 ",
								nativeQuery = true) 
	Page<Employees> findByCategorySearch(String whatSearch, String q, Pageable pageable);

}
