package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CategoryVO;

@Controller
public class ChangePasswordController {

	@RequestMapping(value="/user/changePassword",method=RequestMethod.GET)
	public ModelAndView loadCategory(){
		return new ModelAndView("/user/changePassword");
	}
}
