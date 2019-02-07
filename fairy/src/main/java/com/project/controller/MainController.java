package com.project.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.project.service.RegisterService;

@Controller
public class MainController {

	//@Autowired
	//RegisterService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView loadIndex(){
		
		return new ModelAndView("/admin/index");
		
	}
	
}
