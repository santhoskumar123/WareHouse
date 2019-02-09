package com.app.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//reading data from model
				@SuppressWarnings("unchecked")
				List<Item> list=(List<Item>) model.get("list");
				//creating sheet
				Sheet sheet=workbook.createSheet("Items");
				//set Head-row-0
				setHead(sheet);
				//set Body-Row#1
				setBody(sheet,list);
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ITEM ID");
		row.createCell(1).setCellValue("ITEM CODE");
		row.createCell(2).setCellValue("ITEM LENGTH");
		row.createCell(3).setCellValue("ITEM WIDTH");
		row.createCell(4).setCellValue("ITEM HEIGHT");
		row.createCell(5).setCellValue(" BASECOST");
		row.createCell(6).setCellValue("BASE CURRENCY");
		row.createCell(7).setCellValue("ITEM DSC");
		
	}
	
	private void setBody(Sheet sheet, List<Item> list) {
		int rowNum=1;
		for(Item i :list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(i.getItemId());
			row.createCell(1).setCellValue(i.getItemCode());
			row.createCell(2).setCellValue(i.getItemLen());
			row.createCell(3).setCellValue(i.getItemWidth());
			row.createCell(4).setCellValue(i.getItemHeight());
			row.createCell(5).setCellValue(i.getBaseCost());
			row.createCell(6).setCellValue(i.getBaseCurrency());
			row.createCell(7).setCellValue(i.getItemDsc());
		}
	}


}
