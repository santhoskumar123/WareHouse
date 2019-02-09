package com.app.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument (
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		//reading data from model
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		//creating sheet
		Sheet sheet=workbook.createSheet("WhUserTypes");
		//set Head-row-0
		setHead(sheet);
		//set Body-Row#1
		setBody(sheet,list);
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("UserType");
		row.createCell(2).setCellValue("UserCode");
		row.createCell(3).setCellValue("UserFor");
		row.createCell(4).setCellValue("UserEmail");
		row.createCell(5).setCellValue("UserContact");
		row.createCell(6).setCellValue("UserIdType");
		row.createCell(7).setCellValue("IfOther");
		row.createCell(8).setCellValue("Number");
		
	}
	
	private void setBody(Sheet sheet, List<WhUserType> list) {
		int rowNum=1;
		for(WhUserType w :list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getUserType());
			row.createCell(2).setCellValue(w.getUserCode());
			row.createCell(3).setCellValue(w.getUserFor());
			row.createCell(4).setCellValue(w.getUserEmail());
			row.createCell(5).setCellValue(w.getUserContact());
			row.createCell(6).setCellValue(w.getUserIdType());
			row.createCell(7).setCellValue(w.getIdNumber());
		}
	}


}
