package com.app.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument (
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		//reading data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		//creating sheet
		Sheet sheet=workbook.createSheet("Order Methods");
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
		row.createCell(3).setCellValue("EXETYPE");
		row.createCell(4).setCellValue("ORDERACCEPT");
		row.createCell(5).setCellValue("ORDERDSC");
		
	}
	
	private void setBody(Sheet sheet, List<OrderMethod> list) {
		int rowNum=1;
		for(OrderMethod o :list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(o.getId());
			row.createCell(1).setCellValue(o.getOrderMode());
			row.createCell(2).setCellValue(o.getOrderCode());
			row.createCell(3).setCellValue(o.getExeType());
			row.createCell(4).setCellValue(o.getOrderAccept().toString());
			row.createCell(5).setCellValue(o.getOrderDsc());
		}
	}

}
