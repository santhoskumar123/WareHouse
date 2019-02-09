package com.app.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		//reading data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		//creating sheet
		Sheet sheet=workbook.createSheet("Shipment Types");
		//set Head-row-0
		setHead(sheet);
		//set Body-Row#1
		setBody(sheet,list);
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("NOTE");
		
	}
	
	private void setBody(Sheet sheet, List<ShipmentType> list) {
		int rowNum=1;
		for(ShipmentType s:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getShipmentMode());
			row.createCell(2).setCellValue(s.getShipmentCode());
			row.createCell(3).setCellValue(s.getEnableShipment());
			row.createCell(4).setCellValue(s.getShipmentGrade());
			row.createCell(5).setCellValue(s.getShipDesc());
		}
	}
}
