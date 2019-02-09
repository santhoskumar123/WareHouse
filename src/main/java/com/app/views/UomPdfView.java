package com.app.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//set file name
		response.setHeader("Content-Disposition", "attachment;filename=UOMS.pdf");
		//read model data
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>) model.get("list");
		
		//#1 Create any Element
		Paragraph p=new Paragraph("Hello PDF");
		//#2 Add Element to doc
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("UTYPE");
		table.addCell("UMODEL");
		table.addCell("UDES");
		
		for(Uom u:list) {
			table.addCell(u.getId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getUomDes());
			}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
		
	}



}
