package com.project.controller;

import java.util.List;

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
import com.project.utils.Basemethods;

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

	@RequestMapping(value = "user/registerInsert", method = RequestMethod.POST)
	public ModelAndView userEditProfile(@ModelAttribute RegisterVO registerVO,@ModelAttribute LoginVO loginVO) 
	{
		loginVO.setLoginId(registerVO.getLoginVO().getLoginId());
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
        loginVO.setEnabled(registerVO.getLoginVO().getEnabled());
        loginVO.setStatus(registerVO.getLoginVO().isStatus());
        loginVO.setRole(registerVO.getLoginVO().getRole());
		
		this.loginService.insertLogin(loginVO);
		
		registerVO.setLoginVO(loginVO);
		this.registerService.registerInsert(registerVO);
		
		return new ModelAndView("redirect:/user/editProfile");
	}
	
	@RequestMapping(value = "user/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile(){
		
		String userName = Basemethods.getUser();
		 
		List loginList = loginService.searchLoginID(userName);
		
		LoginVO loginVO = (LoginVO) loginList.get(0);
		
		List registerList = registerService.searchUser(loginVO);
		
		
		RegisterVO registerVO = (RegisterVO)registerList.get(0);
		
		return new ModelAndView("user/addProfile","RegisterVO",registerVO);
	}
	
	
}
