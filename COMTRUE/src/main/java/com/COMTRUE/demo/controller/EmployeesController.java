package com.COMTRUE.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.COMTRUE.demo.service.EmployeesService;

@Controller
public class EmployeesController {

	@Autowired
	EmployeesService service;

	@GetMapping("/index")
	private String index(@RequestParam(required = false) String whatSearch, @RequestParam(required = false) String q,
			Model model) {
		if (q == null || q.equals("")) {
			model.addAttribute("employeesList", service.findAll());
		} else {
			model.addAttribute("employeesList", service.findByCategorySearch(whatSearch.trim(), q.trim()));
		}
		return "main";
	}
}
