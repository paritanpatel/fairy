package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.TemplateVO;
import com.project.service.TemplateService;

@Controller
public class TemplateController
{
	@Autowired 
	TemplateService templateservice;

	@RequestMapping(value="/admin/loadTemplate",method=RequestMethod.GET)
	public ModelAndView loadTemplate()
	{
		return new ModelAndView("/admin/addTemplate","TemplateVO",new TemplateVO());
	}

	@RequestMapping(value="/admin/insertTemplate",method=RequestMethod.POST)
	public ModelAndView insertTemplate(@ModelAttribute TemplateVO templateVO){
		templateVO.setStatus(true);
		this.templateservice.insert(templateVO);
		return new ModelAndView("redirect:/admin/viewTemplate");
	}
	
	@RequestMapping(value="/admin/viewTemplate",method=RequestMethod.GET)
	public ModelAndView viewTemplate(@ModelAttribute TemplateVO templateVO){
		List templateList=this.templateservice.search();
		return new ModelAndView("/admin/viewTemplate","templateList",templateList);
	}
	
	@RequestMapping(value="/admin/deleteTemplate",method=RequestMethod.GET)
	public ModelAndView deleteTemplate(@ModelAttribute TemplateVO templateVO,@RequestParam String templateId){

		templateVO.setId(Integer.parseInt(templateId));
		List templateList = this.templateservice.edit(templateVO);
		
		TemplateVO templateVO2  = (TemplateVO) templateList.get(0);
		templateVO2.setStatus(false);
		
		this.templateservice.insert(templateVO2);
		
		return new ModelAndView("redirect:/admin/viewTemplate");
	}
	
	@RequestMapping(value="admin/editTemplate",method=RequestMethod.GET)
	public ModelAndView editTemplate(@ModelAttribute TemplateVO templateVO,@RequestParam String templateId){
		
		templateVO.setId(Integer.parseInt(templateId));
		List templateList=this.templateservice.edit(templateVO);
		
		TemplateVO templateVO2  = (TemplateVO) templateList.get(0);
		return new ModelAndView("/admin/addTemplate","TemplateVO",templateVO2);
	}

}
