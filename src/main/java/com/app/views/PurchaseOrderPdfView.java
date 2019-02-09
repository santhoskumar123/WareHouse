package com.app.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.PurchaseOrder;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchaseOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set file name
				response.setHeader("Content-Disposition", "attachment;filename=PurchaseOrders.pdf");
				//read model data
				@SuppressWarnings("unchecked")
				List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
				
				//#1 Create any Element
				Paragraph p=new Paragraph("Hello PDF");
				//#2 Add Element to doc
				document.add(p);
				
				PdfPTable table=new PdfPTable(6);
				table.addCell("ID");
				table.addCell("CODE");
				table.addCell("MODE");
				table.addCell("VENDOR");
				table.addCell("REFNO");
				table.addCell("QUALITYCHECK");
				table.addCell("ORDERSTATUS");
				table.addCell("ORDERDSC");
				
				for(PurchaseOrder po:list) {
					table.addCell(po.getOrderId().toString());
					table.addCell(po.getOrderCode());
					table.addCell(po.getShipmentMode());
					table.addCell(po.getVendor());
					table.addCell((po.getRefNum()));
					table.addCell(po.getQualityCheck());
					table.addCell(po.getOrderStatus());
					table.addCell(po.getOrderDsc());
				}
				
				document.add(table);
				
				//Display generated Date
				document.add(new Paragraph(new Date().toString()));
				
				
				
			}




	}


