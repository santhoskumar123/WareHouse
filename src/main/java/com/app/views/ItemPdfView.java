package com.app.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set file name
				response.setHeader("Content-Disposition", "attachment;filename=ITEMS.pdf");
				//read model data
				@SuppressWarnings("unchecked")
				List<Item> list=(List<Item>) model.get("list");
				
				//#1 Create any Element
				Paragraph p=new Paragraph("Hello PDF");
				//#2 Add Element to doc
				document.add(p);
				
				PdfPTable table=new PdfPTable(6);
				table.addCell("ITEM ID");
				table.addCell("ITEMCODE");
				table.addCell("ITEM LENGTH");
				table.addCell("ITEM WIDTH");
				table.addCell("ITEM HEIGHT");
				table.addCell("BASE COST");
				table.addCell("BASE CURRENCY");
				table.addCell("ITEM DSC");
				
				for(Item i:list) {
					table.addCell(i.getItemId().toString());
					table.addCell(i.getItemCode());
					table.addCell(i.getItemLen().toString());
					table.addCell(i.getItemWidth().toString());
					table.addCell((i.getItemHeight().toString()));
					table.addCell(i.getBaseCost().toString());
					table.addCell(i.getBaseCurrency());
					table.addCell(i.getItemDsc());
				}
				
				document.add(table);
				
				//Display generated Date
				document.add(new Paragraph(new Date().toString()));
				
				
				
			}

	

}
