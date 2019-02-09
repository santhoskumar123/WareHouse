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

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.validator.ItemValidator;
import com.app.views.ItemExcelView;
import com.app.views.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IItemService service;
	@Autowired
	private ItemValidator validator;
	// show register page
		@RequestMapping("/register")
		public String showReg(ModelMap map) {
			map.addAttribute("item", new Item());
			return "ItemRegister";
		}
		// insert data in db
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String save(@ModelAttribute Item item,Errors errors, ModelMap map) {
			validator.validate(item, errors);
			if(errors.hasErrors()) {
				map.addAttribute("message","Check all errors!!");
			}else {
				int id = service.saveItem(item);
				String msg = "saved with id:" + id;
				map.addAttribute("message", msg);
				map.addAttribute("item", new Item());
			}
			return "ItemRegister";

		}
		@RequestMapping("/all")
		public String viewAll(ModelMap map) {
			List<Item> obs=service.getAllItems();
			map.addAttribute("list",obs);
			return "ItemData";
		}
		@RequestMapping("/delete")
		public String Delete(@RequestParam("oid") Integer id,ModelMap map) {
			service.deleteItem(id);
			List<Item> obs=service.getAllItems();
			map.addAttribute("list",obs);
			map.addAttribute("message", "record deleted with id:"+id);
			return "ItemData";
			
		}
		@RequestMapping("/view")
		public String getOne(@RequestParam("oid") Integer id,ModelMap map) {
			Item ob=service.getItemById(id);
			map.addAttribute("i",ob);
			return "ItemView";
		}
		@RequestMapping("/editOne")
		public String showData(@RequestParam Integer oid,ModelMap map) {
			Item i=service.getItemById(oid);
			map.addAttribute("item",i);
			return "ItemEdit";
			
		}
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String doUpdate(@ModelAttribute Item item, ModelMap map) {
			service.updateItem(item);
			map.addAttribute("message", "item updated");
			map.addAttribute("list", service.getAllItems());
			return "ItemData";

		}

		@RequestMapping("/excelExport")
		public ModelAndView doExcelExport() {

			List<Item> it= service.getAllItems();
			return new ModelAndView(new ItemExcelView(), "list", it);

		}

		// 8. Export Data to Excel
		@RequestMapping("/exportExcelOne")
		public ModelAndView doOneExcelExport(@RequestParam Integer id) {
			// reading data from DB
			Item it = service.getItemById(id);
			// view, key,val
			return new ModelAndView(new ItemExcelView(), "list", Arrays.asList(it));
		}
		//10. Export Data to PDF
		@RequestMapping("/pdfExp")
		public ModelAndView exportPdfData() {
			List<Item> list=service.getAllItems();
			return new ModelAndView(new ItemPdfView(),"list",list);
		}


		@RequestMapping("/exportPdfOne")
		public ModelAndView doOnePdfExport(@RequestParam Integer id) {
			//reading data from DB
			Item it=service.getItemById(id);
			//view, key,val
			return new ModelAndView(
					new ItemPdfView(), 
					"list", Arrays.asList(it));
		}



}
