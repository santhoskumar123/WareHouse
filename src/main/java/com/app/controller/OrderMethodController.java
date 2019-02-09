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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validator.OrderMethodValidator;
import com.app.views.OrderMethodExcelView;
import com.app.views.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodUtil util;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodValidator validator;
	
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
		//1.calling validatot
		validator.validate(orderMethod, errors);
		//2.check for errors
		if(errors.hasErrors()) {
			map.addAttribute("message"," pls check all errors");
		}
		else {
		Integer id=service.saveOrderMethod(orderMethod);
		map.addAttribute("message","saved with id:"+id);
		//clean form
		map.addAttribute("orderMethod",new OrderMethod());
		}
		return "OrderMethodRegister";
		
	}
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<OrderMethod> obs=service.getAllOrderMethods();
		map.addAttribute("list",obs);
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String Delete(@RequestParam("oid") Integer id,ModelMap map) {
		service.deleteOrdermethod(id);
		List<OrderMethod> obs=service.getAllOrderMethods();
		map.addAttribute("list",obs);
		map.addAttribute("message", "record deleted with id:"+id);
		return "OrderMethodData";
		
	}
	@RequestMapping("/view")
	public String getOne(@RequestParam("oid") Integer id,ModelMap map) {
		OrderMethod ob=service.getOrderMethodById(id);
		map.addAttribute("om",ob);
		return "OrderMethodView";
	}
	@RequestMapping("/editOne")
	public String showData(@RequestParam Integer oid,ModelMap map) {
		OrderMethod om=service.getOrderMethodById(oid);
		map.addAttribute("orderMethod",om);
		return "OrderMethodEdit";
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUdate(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		service.updateOrderMethod(orderMethod);
		map.addAttribute("message","updated successfully");
		map.addAttribute("list",service.getAllOrderMethods());
		map.addAttribute("message","deleted success fully");
		return "OrderMethodData";
		
	}
	@RequestMapping("/excelExport")
	public ModelAndView doExcelExport() {

		List<OrderMethod> om = service.getAllOrderMethods();
		return new ModelAndView(new OrderMethodExcelView(), "list", om);

	}
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer id) {
		// reading data from DB
		OrderMethod om = service.getOrderMethodById(id);
		// view, key,val
		return new ModelAndView(new OrderMethodExcelView(), "list", Arrays.asList(om));
	}
	@RequestMapping("/pdfExp")
	public ModelAndView exportPdfData() {
		List<OrderMethod> list=service.getAllOrderMethods();
		return new ModelAndView(new OrderMethodPdfView(),"list",list);
	}
	
	
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		OrderMethod om=service.getOrderMethodById(id);
		//view, key,val
		return new ModelAndView(
				new OrderMethodPdfView(), 
				"list", Arrays.asList(om));
	}
	@RequestMapping("/report")
	public String generatePieChart() {
		String path=context.getRealPath("/");
		List<Object[]> data=service.getOrderModeTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "OrdermethodReport";
	}


}
