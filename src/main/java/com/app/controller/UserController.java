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

import com.app.model.User;
import com.app.service.IUserService;
import com.app.validator.UserValidator;
import com.app.views.UserExcelView;
import com.app.views.UserPdfView;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private UserValidator validator;
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("user",new User());
		return "UserRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute User u,Errors errors,ModelMap map) {
		validator.validate(u, errors);
		//2.check for errors
		if(errors.hasErrors()) {
			map.addAttribute("message"," pls check all errors");
		}
		else {
			Integer id=service.saveUser(u);
			map.addAttribute("message","saved with id:"+id);
			map.addAttribute("user",new User());
		}
		return "UserRegister";
	}
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<User> obs=service.getAllUsers();
		map.addAttribute("list",obs);
		return "UserData";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map) {
		service.deleteUser(id);
		List<User> obs=service.getAllUsers();
		map.addAttribute("list",obs);
		map.addAttribute("message","record deleted with id:"+id);
		return "UserData";
	}
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {
		User ob=service.getUserById(id);
		map.addAttribute("u",ob);
		return "UserView";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map) {
		User u=service.getUserById(id);
		map.addAttribute("user",u);
		return "UserEdit";

	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute User user,ModelMap map) {
		service.updateUser(user);
		map.addAttribute("message","User updated successfully");
		map.addAttribute("list",service.getAllUsers());
		return "UserData";

	}
	@RequestMapping("/excelExport")
	public ModelAndView excelExport() {
		List<User> u=service.getAllUsers();
		return new ModelAndView(new UserExcelView(),"list",u);
	}
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer id) {
		// reading data from DB
		User u = service.getUserById(id);
		// view, key,val
		return new ModelAndView(new UserExcelView(), "list", Arrays.asList(u));
	}
	@RequestMapping("/pdfExp")
	public ModelAndView exportPdfData() {
		List<User> list=service.getAllUsers();
		return new ModelAndView(new UserPdfView(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		User u=service.getUserById(id);
		//view, key,val
		return new ModelAndView(new UserPdfView(),"list",Arrays.asList(u));
	}





}
