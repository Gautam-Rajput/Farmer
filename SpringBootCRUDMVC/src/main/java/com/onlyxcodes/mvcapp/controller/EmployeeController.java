package com.onlyxcodes.mvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlyxcodes.mvcapp.model.Employee;
import com.onlyxcodes.mvcapp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String viewIndexPage(Model model){
		List<Employee> employeeList = service.listAll();
		model.addAttribute("getAllEmployee", employeeList);
		return "index";
	}
	
	@RequestMapping("/new_add")
	public String viewNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "insert";
	}
	
	@RequestMapping(value = "/save_employee", method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
		service.create(employee);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEditEmployeeForm(@PathVariable(name = "id") long id) {
		
		ModelAndView mav = new ModelAndView("update");	
		Employee employee = service.updateid(id);
		mav.addObject("employee", employee);
		return mav;	
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") long id) {
		
		service.delete(id);
		return "redirect:/";
	}

}
