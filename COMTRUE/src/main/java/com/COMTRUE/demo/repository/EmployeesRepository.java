package com.COMTRUE.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.COMTRUE.demo.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, String> {

	@Query(value = " SELECT * FROM employees "
								+ " WHERE ?1 LIKE %?2% ",
								nativeQuery = true) 
	List<Employees> findByCategorySearch(String whatSearch, String q);

}
