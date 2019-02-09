package com.app.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//set file name
		response.setHeader("Content-Disposition", "attachment;filename=ORDERMETHODS.pdf");
		//read model data
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		
		//#1 Create any Element
		Paragraph p=new Paragraph("Hello PDF");
		//#2 Add Element to doc
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("EXETYPE");
		table.addCell("ORDERACCEPT");
		table.addCell("ORDERDSC");
		
		for(OrderMethod o:list) {
			table.addCell(o.getId().toString());
			table.addCell(o.getOrderCode());
			table.addCell(o.getOrderMode());
			table.addCell(o.getExeType());
			table.addCell((o.getOrderAccept().toString()));
			table.addCell(o.getOrderDsc());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
		
	}



}
