package com.app.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import com.app.model.User;

public class UserExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>) model.get("list");
		//creating sheet
		Sheet sheet=workbook.createSheet("Users");
		//set Head-row-0
		setHead(sheet);
		//set Body-Row#1
		setBody(sheet,list);
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("MOBILE");
		row.createCell(3).setCellValue("PWD");
		row.createCell(3).setCellValue("ROLES");
			}
	
	private void setBody(Sheet sheet, List<User> list) {
		int rowNum=1;
		for(User u:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getUserId());
			row.createCell(1).setCellValue(u.getUserName());
			row.createCell(2).setCellValue(u.getUserEmail());
			row.createCell(3).setCellValue(u.getMobile());
			row.createCell(3).setCellValue(u.getUserPwd());
			row.createCell(3).setCellValue(u.getRoles().toString());
			
		}
	}


	

}
