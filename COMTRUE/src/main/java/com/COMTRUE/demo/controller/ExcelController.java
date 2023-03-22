package com.COMTRUE.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.COMTRUE.demo.service.ExcelService;

@Controller
public class ExcelController {

	@Autowired
	private ExcelService excelService;

	@GetMapping("/excel")
	public void excelDownload(HttpServletResponse res) {
		excelService.download(res);
	}
}
