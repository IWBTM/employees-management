package com.COMTRUE.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.COMTRUE.demo.dto.res.ResponseDto;
import com.COMTRUE.demo.entity.Employees;
import com.COMTRUE.demo.service.EmployeesService;

@RestController
@RequestMapping("/api/employees")
public class EmployeesApiController {

	@Autowired
	private EmployeesService service;

	@PostMapping("/add")
	private ResponseDto<?> add(@RequestBody Employees employees) {
		System.out.println(employees.getId().length());
		if (employees.getId().length() < 2) {
			return new ResponseDto<>(false, "회원 번호는 3자리 이상이어야 합니다.");
		}
		return new ResponseDto<>(service.add(employees), "성공적으로 추가되었습니다.");
	}

	@DeleteMapping("/delete/{id}")
	private ResponseDto<?> delete(@PathVariable String id) {
		return new ResponseDto<>(service.delete(id), "삭제하였습니다.");
	}

	@GetMapping("/findById/{id}")
	private ResponseDto<?> findById(@PathVariable String id) {
		return new ResponseDto<>(true, service.findById(id));
	}

	@PostMapping("/update/{originId}")
	private ResponseDto<?> update(@PathVariable String originId, @RequestBody Employees employees) {
		return new ResponseDto<>(service.update(originId, employees), "수정되었습니다.");
	}
}
