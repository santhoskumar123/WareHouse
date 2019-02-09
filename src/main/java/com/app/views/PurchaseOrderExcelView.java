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
import com.app.model.PurchaseOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//reading data from model
			@SuppressWarnings("unchecked")
			List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
			//creating sheet
			Sheet sheet=workbook.createSheet("PurchaseOrders");
			//set Head-row-0
			setHead(sheet);
			//set Body-Row#1
			setBody(sheet,list);
			
		}

		private void setHead(Sheet sheet) {
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("CODE");
			row.createCell(2).setCellValue("MODE");
			row.createCell(3).setCellValue("VENDOR");
			row.createCell(4).setCellValue("REFNO");
			row.createCell(5).setCellValue("QUALITYCHECK");
			row.createCell(6).setCellValue("ORDERSTATUS");
			row.createCell(7).setCellValue("ORDERDSC");
			
		}
		
		private void setBody(Sheet sheet, List<PurchaseOrder> list) {
			int rowNum=1;
			for(PurchaseOrder po:list) {
				Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(po.getOrderId());
				row.createCell(1).setCellValue(po.getOrderCode());
				row.createCell(2).setCellValue(po.getShipmentMode());
				row.createCell(3).setCellValue(po.getVendor());
				row.createCell(4).setCellValue(po.getRefNum());
				row.createCell(5).setCellValue(po.getQualityCheck());
				row.createCell(6).setCellValue(po.getOrderStatus());
				row.createCell(7).setCellValue(po.getOrderDsc());
				
			}
		}


	}


