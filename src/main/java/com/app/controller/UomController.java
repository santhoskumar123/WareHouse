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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;
import com.app.views.ShipmentTypePdfView;
import com.app.views.UomExcelView;
import com.app.views.UomPdfView;
@Controller
@RequestMapping("/Uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;
	@Autowired
	private UomValidator validator;
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		//1.calling validator
		validator.validate(uom, errors);
		//2.check for errors
		if(errors.hasErrors()) {
			map.addAttribute("message"," pls check all errors");
		}
		else {
			int id=service.saveUom(uom);
			String msg="saved with id:"+id;
			map.addAttribute("message", msg);
			//clean form
			map.addAttribute("uom",new Uom());
		}
		return "UomRegister";

	}

	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<Uom> obs=service.getAllUoms();
		map.addAttribute("list",obs);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String Delete(@RequestParam("uid") Integer id,ModelMap map) {

		service.deleteUom(id);
		List<Uom> obs=service.getAllUoms();
		map.addAttribute("list",obs);
		map.addAttribute("message","Record deleted:"+id);
		return "UomData";
	}
	@RequestMapping("/view")
	public String getOne(@RequestParam("uid") Integer id,ModelMap map) {
		Uom ob=service.getUomById(id);
		map.addAttribute("u", ob);
		return "UomView";
	}
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer uid,ModelMap map) {
		Uom u=service.getUomById(uid);
		map.addAttribute("uom",u);

		return "UomEdit";

	}
	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute Uom uom,ModelMap map) {
		service.updateUom(uom);
		map.addAttribute("message","updated successfully");
		map.addAttribute("list",service.getAllUoms());
		return "UomData";
	}
	@RequestMapping("/excelExport")
	public ModelAndView doExcelExport() {

		List<Uom> u = service.getAllUoms();
		return new ModelAndView(new UomExcelView(), "list", u);

	}

	// 8. Export Data to Excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer id) {
		// reading data from DB
		Uom u = service.getUomById(id);
		// view, key,val
		return new ModelAndView(new UomExcelView(), "list", Arrays.asList(u));
	}
	@RequestMapping("/pdfExp")
	public ModelAndView exportPdfData() {
		List<Uom> list=service.getAllUoms();
		return new ModelAndView(new ShipmentTypePdfView(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		Uom u=service.getUomById(id);
		//view, key,val
		return new ModelAndView(
				new UomPdfView(), 
				"list", Arrays.asList(u));
	}
	@RequestMapping("/report")
	public String generateCharts() {
		String path=context.getRealPath("/");
		List<Object[]> data=service.getUomTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "UomReport";
	}


}
