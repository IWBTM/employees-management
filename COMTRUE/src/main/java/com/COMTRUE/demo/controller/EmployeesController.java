package com.COMTRUE.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.COMTRUE.demo.service.EmployeesService;

@Controller
public class EmployeesController {

	@Autowired
	EmployeesService service;

	@GetMapping({ "/main", "" })
	private String main(@PageableDefault(size = 10, sort = "name", direction = Direction.ASC) Pageable pageable,
			@RequestParam(required = false) String whatSearch, @RequestParam(required = false) String q, Model model) {
		String myQ = q == null ? "" : q;
		if (myQ == "") {
			model.addAttribute("employeesList", service.findAll(pageable));
		} else {
			model.addAttribute("employeesList", service.findByCategorySearch(whatSearch, myQ, pageable));
		}
		model.addAttribute("q", myQ);
		return "main";
	}
}
