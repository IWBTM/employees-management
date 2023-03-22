package com.COMTRUE.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

	private int cellNum;
	private int rowNum;
	private Cell cell;
	private Row row;

	@Autowired
	private EmployeesService employeesService;

	public void download(HttpServletResponse res) {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("first sheet");
		rowNum = 0;
		cellNum = 0;

		row = null;
		cell = null;

		// header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(cellNum++);
		cell.setCellValue("직원 번호");
		cell = row.createCell(cellNum++);
		cell.setCellValue("이름");
		cell = row.createCell(cellNum++);
		cell.setCellValue("직급");
		cell = row.createCell(cellNum++);
		cell.setCellValue("전화번호");
		cell = row.createCell(cellNum++);
		cell.setCellValue("이메일");

		// body
		employeesService.findAll().forEach(employees -> {
			cellNum = 0;
			row = sheet.createRow(rowNum++);
			cell = row.createCell(cellNum++);
			cell.setCellValue(employees.getId());
			cell = row.createCell(cellNum++);
			cell.setCellValue(employees.getName());
			cell = row.createCell(cellNum++);
			cell.setCellValue(employees.getPosition());
			cell = row.createCell(cellNum++);
			cell.setCellValue(employees.getPhoneNumber());
			cell = row.createCell(cellNum++);
			cell.setCellValue(employees.getEmail());
		});

		res.setContentType("ms-vnd/excel");
		res.setHeader("Content-Disposition", "attachment; filename=student.xlsx");

		try {
			wb.write(res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
