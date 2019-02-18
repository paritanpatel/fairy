package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.model.CategoryVO;
import com.project.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired 
	CategoryService categoryservice;

	@RequestMapping(value="/admin/loadCategory",method=RequestMethod.GET)
	public ModelAndView loadCategory(){
		return new ModelAndView("/admin/addCategory","CategoryVO",new CategoryVO());
	}
	
	@RequestMapping(value="/admin/insertCategory",method=RequestMethod.POST)
	public ModelAndView insertCategory(@ModelAttribute CategoryVO categoryVO){
		categoryVO.setStatus(true);
		this.categoryservice.insert(categoryVO);
		return new ModelAndView("redirect:/admin/viewCategory");
	}
	
	@RequestMapping(value="/admin/viewCategory",method=RequestMethod.GET)
	public ModelAndView viewCategory(@ModelAttribute CategoryVO categoryVO){
		List categoryList=this.categoryservice.search();
		return new ModelAndView("/admin/viewCategory","categoryList",categoryList);
	}
	
	@RequestMapping(value="/admin/deleteCategory",method=RequestMethod.GET)
	public ModelAndView deleteCategory(@ModelAttribute CategoryVO categoryVO,@RequestParam String categoryId){

		categoryVO.setId(Integer.parseInt(categoryId));
		List categoryList = this.categoryservice.edit(categoryVO);
		
		CategoryVO categoryVO2  = (CategoryVO) categoryList.get(0);
		categoryVO2.setStatus(false);
		
		this.categoryservice.insert(categoryVO2);
		
		return new ModelAndView("redirect:/admin/viewCategory");
	}
	
	@RequestMapping(value="/admin/editCategory",method=RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute CategoryVO categoryVO,@RequestParam String categoryId){
		
		categoryVO.setId(Integer.parseInt(categoryId));
		List categoryList=this.categoryservice.edit(categoryVO);
		
		CategoryVO categoryVO2  = (CategoryVO) categoryList.get(0);
		return new ModelAndView("/admin/addCategory","CategoryVO",categoryVO2);
	}
}
