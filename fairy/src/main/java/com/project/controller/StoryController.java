package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.CategoryService;
import com.project.service.SubCategoryService;

@Controller
public class StoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	
	@RequestMapping(value="/user/searchUserCategory",method=RequestMethod.GET)
	public ModelAndView insertCategory(){
		List categoryList = this.categoryService.search();
		return new ModelAndView("user/viewCategory","categoryList",categoryList);
	}
	
}
