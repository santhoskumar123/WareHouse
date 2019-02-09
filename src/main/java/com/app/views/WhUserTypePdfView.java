package com.app.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//set file name
		response.setHeader("Content-Disposition", "attachment;filename=WHTYPES.pdf");
		//read model data
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		//#1 Create any Element
		Paragraph p=new Paragraph("Hello PDF");
		//#2 Add Element to doc
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("UserType");
		table.addCell("UserCode");
		table.addCell("UserFor");
		table.addCell("UserEmail");
		table.addCell("UserContact");
		table.addCell("UserIdType");
		table.addCell("IfOther");
		table.addCell("Number");
		
		for(WhUserType w:list) {
			table.addCell(w.getId().toString());
			table.addCell(w.getUserType());
			table.addCell(w.getUserCode());
			table.addCell(w.getUserFor());
			table.addCell((w.getUserEmail()));
			table.addCell(w.getUserContact());
			table.addCell(w.getUserIdType());
			table.addCell(w.getIfOther());
			table.addCell(w.getIdNumber());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
		
	}





}
