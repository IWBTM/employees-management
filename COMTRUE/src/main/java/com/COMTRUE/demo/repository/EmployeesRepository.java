package com.COMTRUE.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.COMTRUE.demo.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, String> {

	@Query(value = " SELECT * "
								+ " FROM employees "
								+ " WHERE :whatSearch LIKE %:q% ",
								nativeQuery = true) 
	List<Employees> findByCategorySearch(@Param("whatSearch") String whatSearch,@Param("q") String q);

}
