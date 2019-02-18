package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;
import com.project.service.LoginService;
import com.project.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() 
	{
		return new ModelAndView("register","RegisterVO",new RegisterVO());
	}
	
	@RequestMapping(value = "/registerInsert", method = RequestMethod.POST)
	public ModelAndView registerInsert(@ModelAttribute RegisterVO registerVO,@ModelAttribute LoginVO loginVO) 
	{
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
        loginVO.setEnabled("1");
        loginVO.setStatus(true);
        loginVO.setRole("ROLE_USER");
		
		this.loginService.insertLogin(loginVO);
		
		registerVO.setLoginVO(loginVO);
		this.registerService.registerInsert(registerVO);
		
		return new ModelAndView("redirect:/login");
	}
	
	
	
}
