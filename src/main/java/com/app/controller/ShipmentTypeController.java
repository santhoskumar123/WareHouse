package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.validator.ShipmentTypeValidator;
import com.app.views.ShipmentTypeExcelView;
import com.app.views.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;
	@Autowired
	private ShipmentTypeValidator validator;

	// show register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	// insert data in db
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String save(@ModelAttribute ShipmentType shipmentType,Errors errors, ModelMap map) {
		// calling service layer save method
		validator.validate(shipmentType, errors);
		//2.check for errors
		if(errors.hasErrors()) {
			map.addAttribute("message"," pls check all errors");
		}
		else {
			int id = service.saveShipmentType(shipmentType);
			String msg = "saved with id:" + id;
			map.addAttribute("message", msg);
			map.addAttribute("shipmentType", new ShipmentType());
		}
		return "ShipmentTypeRegister";

	}

	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<ShipmentType> obs = service.getAllShipmentTypes();
		map.addAttribute("list", obs);
		return "ShipmentTypeData";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("sid") Integer id, ModelMap map) {
		service.deleteShipmentType(id);
		List<ShipmentType> obs = service.getAllShipmentTypes();
		map.addAttribute("list", obs);
		map.addAttribute("message", "record deletde:" + id);

		return "ShipmentTypeData";
	}

	@RequestMapping("/view")
	public String getOne(@RequestParam("sid") Integer id, ModelMap map) {
		ShipmentType ob = service.getShipmantTypeById(id);
		map.addAttribute("st", ob);
		return "ShipmentTypeView";

	}

	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer sid, ModelMap map) {
		ShipmentType st = service.getShipmantTypeById(sid);
		map.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdate(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		service.updateShipmentType(shipmentType);
		map.addAttribute("message", "shipment updated");
		map.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";

	}

	@RequestMapping("/excelExport")
	public ModelAndView doExcelExport() {

		List<ShipmentType> st = service.getAllShipmentTypes();
		return new ModelAndView(new ShipmentTypeExcelView(), "list", st);

	}

	// 8. Export Data to Excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer sid) {
		// reading data from DB
		ShipmentType st = service.getShipmantTypeById(sid);
		// view, key,val
		return new ModelAndView(new ShipmentTypeExcelView(), "list", Arrays.asList(st));
	}
	//10. Export Data to PDF
	@RequestMapping("/pdfExp")
	public ModelAndView exportPdfData() {
		List<ShipmentType> list=service.getAllShipmentTypes();
		return new ModelAndView(new ShipmentTypePdfView(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer sid) {
		//reading data from DB
		ShipmentType st=service.getShipmantTypeById(sid);
		//view, key,val
		return new ModelAndView(
				new ShipmentTypePdfView(), 
				"list", Arrays.asList(st));
	}
	@RequestMapping("/report")
	public String generateCharts() {
		String path=context.getRealPath("/");
		List<Object[]> data=service.getShipmentTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "ShipmentTypeReport";

	}



}
