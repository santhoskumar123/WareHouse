package com.app.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import com.app.validator.PurchaseOrderValidator;
import com.app.views.PurchaseOrderExcelView;
import com.app.views.PurchaseOrderPdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private PurchaseOrderValidator validator;
	// show register page
		@RequestMapping("/register")
		public String showReg(ModelMap map) {
			map.addAttribute("purchaseOrder", new PurchaseOrder());
			return "PurchaseOrderRegister";
		}
		// insert data in db
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String save(@ModelAttribute PurchaseOrder purchaseOrder,Errors errors, ModelMap map) {
			validator.validate(purchaseOrder, errors);
			if(errors.hasErrors()) {
				map.addAttribute("message","Check all errors!!");
			}else {
				int id = service.savePurchaseOrder(purchaseOrder);
				String msg = "saved with id:" + id;
				map.addAttribute("message", msg);
				map.addAttribute("purchaseOrder", new PurchaseOrder());
			}
			return "PurchaseOrderRegister";

		}
		@RequestMapping("/all")
		public String viewAll(ModelMap map) {
			List<PurchaseOrder> obs=service.getAllPurchaseOrders();
			map.addAttribute("list",obs);
			return "PurchaseOrderData";
		}
		@RequestMapping("/delete")
		public String Delete(@RequestParam("oid") Integer id,ModelMap map) {
			service.deletePurchaseOrder(id);
			List<PurchaseOrder> obs=service.getAllPurchaseOrders();
			map.addAttribute("list",obs);
			map.addAttribute("message", "record deleted with id:"+id);
			return "PurchaseOrderData";
			
		}
		@RequestMapping("/view")
		public String getOne(@RequestParam("oid") Integer id,ModelMap map) {
			PurchaseOrder ob=service.getPurchaseOrderById(id);
			map.addAttribute("po",ob);
			return "PurchaseOrderView";
		}
		@RequestMapping("/editOne")
		public String showData(@RequestParam Integer oid,ModelMap map) {
			PurchaseOrder po=service.getPurchaseOrderById(oid);
			map.addAttribute("purchase",po);
			return "PurchaseOrderEdit";
			
		}
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String doUpdate(@ModelAttribute PurchaseOrder purchase, ModelMap map) {
			service.updatePurchaseOrder(purchase);
			map.addAttribute("message", "PurchaseOrder updated");
			map.addAttribute("list", service.getAllPurchaseOrders());
			return "PurchaseOrderData";

		}

		@RequestMapping("/excelExport")
		public ModelAndView doExcelExport() {

			List<PurchaseOrder> po= service.getAllPurchaseOrders();
			return new ModelAndView(new PurchaseOrderExcelView(), "list", po);

		}

		// 8. Export Data to Excel
		@RequestMapping("/exportExcelOne")
		public ModelAndView doOneExcelExport(@RequestParam Integer id) {
			// reading data from DB
			PurchaseOrder po = service.getPurchaseOrderById(id);
			// view, key,val
			return new ModelAndView(new PurchaseOrderExcelView(), "list", Arrays.asList(po));
		}
		//10. Export Data to PDF
		@RequestMapping("/pdfExp")
		public ModelAndView exportPdfData() {
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			return new ModelAndView(new PurchaseOrderPdfView(),"list",list);
		}


		@RequestMapping("/exportPdfOne")
		public ModelAndView doOnePdfExport(@RequestParam Integer id) {
			//reading data from DB
			PurchaseOrder po=service.getPurchaseOrderById(id);
			//view, key,val
			return new ModelAndView(
					new PurchaseOrderPdfView(), 
					"list", Arrays.asList(po));
		}


}
