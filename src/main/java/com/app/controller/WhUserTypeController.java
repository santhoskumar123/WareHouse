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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
import com.app.validator.WhUserTypeValidator;
import com.app.views.UomPdfView;
import com.app.views.WhUserTypeExcelView;
import com.app.views.WhUserTypePdfView;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	WhUserTypeUtil util;
	@Autowired
	private WhUserTypeValidator validator;

	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("whUserType",new WhUserType());
		return "WhUserTypeRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap map) {
		validator.validate(whUserType, errors);
		//2.check for errors
		if(errors.hasErrors()) {
			map.addAttribute("message"," pls check all errors");
		}
		else {
			Integer id=service.saveWhUserType(whUserType);
			map.addAttribute("message","saved with id:"+id);
			map.addAttribute("whUserType",new WhUserType());
		}
		return "WhUserTypeRegister"; 
	}
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<WhUserType> ob=service.getAllWhUserTypes();
		map.addAttribute("list",ob);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String Delete(@RequestParam Integer uid,ModelMap map) {
		service.deleteWhUserType(uid);
		List<WhUserType> obs=service.getAllWhUserTypes();
		map.addAttribute("list",obs);
		map.addAttribute("message","deleted successfully");

		return "WhUserTypeData";

	}
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer uid,ModelMap map) {
		WhUserType ob=service.getWhUserTypeById(uid);
		map.addAttribute("wut",ob);
		return "WhUserTypeView";

	}
	@RequestMapping("/edit")
	public String Edit(@RequestParam Integer uid,ModelMap map) {
		WhUserType wut=service.getWhUserTypeById(uid);
		map.addAttribute("whUserType",wut);
		return "WhUserTypeEdit";

	}
	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute WhUserType whUserType,ModelMap map) {
		service.updateWhUserType(whUserType);
		map.addAttribute("message","updated succesfully");
		map.addAttribute("list",service.getAllWhUserTypes());
		return "WhUserTypeData";

	}
	@RequestMapping("/excelExport")
	public ModelAndView doExcelExport() {

		List<WhUserType> wh = service.getAllWhUserTypes();
		return new ModelAndView(new WhUserTypeExcelView(), "list", wh);

	}

	// 8. Export Data to Excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer id) {
		// reading data from DB
		WhUserType wh = service.getWhUserTypeById(id);
		// view, key,val
		return new ModelAndView(new WhUserTypeExcelView(), "list", Arrays.asList(wh));
	}
	@RequestMapping("/pdfExp")
	public ModelAndView exportPdfData() {
		List<WhUserType> list=service.getAllWhUserTypes();
		return new ModelAndView(new WhUserTypePdfView(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		WhUserType wh=service.getWhUserTypeById(id);
		//view, key,val
		return new ModelAndView(
				new UomPdfView(), 
				"list", Arrays.asList(wh));
	}
	@RequestMapping("/report")
	public String generateCharts() {
		String path=context.getRealPath("/");
		List<Object[]> data=service.getWhUserTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "WhUserTypeReport";

	}



}
