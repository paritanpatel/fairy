package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.BackgroundVO;
import com.project.model.CategoryVO;
import com.project.model.CharacterVO;
import com.project.model.LoginVO;
import com.project.model.StoryVO;
import com.project.model.SubCategoryVO;
import com.project.model.TemplateVO;
import com.project.service.BackgroundService;
import com.project.service.CategoryService;
import com.project.service.CharacterService;
import com.project.service.LoginService;
import com.project.service.StoryService;
import com.project.service.SubCategoryService;
import com.project.service.TemplateService;
import com.project.utils.Basemethods;

@Controller
public class StoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	BackgroundService backgroundService;
	
	@Autowired
	CharacterService characterService;
	
	@Autowired
	TemplateService templateService;
	
	@Autowired
	StoryService storyService;
	
	@Autowired
	LoginService loginService;
	
	/******************* Category *******************/ 
	@RequestMapping(value="/user/searchUserCategory",method=RequestMethod.GET)
	public ModelAndView insertCategory(){
		List categoryList = this.categoryService.search();
		return new ModelAndView("user/viewStoryCategory","categoryList",categoryList);
	}
	
	/******************* SubCategory *******************/
	@RequestMapping(value="/user/searchUserSubCategory",method=RequestMethod.GET)
	public ModelAndView insertSubCategory(SubCategoryVO subCategoryVO,CategoryVO categoryVO,@RequestParam String categoryId){
		categoryVO.setId((Integer.parseInt(categoryId)));
		subCategoryVO.setCategoryVO(categoryVO);
		List subCategoryList=this.subCategoryService.searchBycategory(subCategoryVO);
		return new ModelAndView("user/viewStorySubCategory","subcategoryList",subCategoryList);
	}
	
	
	/******************* Background *******************/
	@RequestMapping(value="/user/searchUserBackground",method=RequestMethod.GET)
	public ModelAndView insertBackground(BackgroundVO backgroundVO,SubCategoryVO subCategoryVO,@RequestParam String subCategoryId){
		subCategoryVO.setId((Integer.parseInt(subCategoryId)));
		backgroundVO.setSubCategoryVO(subCategoryVO);
		List backgroundList=this.backgroundService.searchBysubCategory(backgroundVO);
		return new ModelAndView("user/viewStoryBackground","backgroundList",backgroundList);
	}
	

	/******************* Character *******************/
	@RequestMapping(value="/user/searchUserCharacter",method=RequestMethod.GET)
	public ModelAndView searchUserCharacter(CharacterVO characterVO,
			SubCategoryVO subCategoryVO,
			@RequestParam String subCategoryId,
			@RequestParam String backgroundId,
			HttpSession session){
		session.setAttribute("backgroundId", backgroundId);
		
		System.out.println("backgroundId : : " + backgroundId );
		subCategoryVO.setId((Integer.parseInt(subCategoryId)));
		characterVO.setSubCategoryVO(subCategoryVO);
		List characterList=this.characterService.searchBysubCategory(characterVO);
		return new ModelAndView("user/viewStoryCharacter","characterList",characterList);
	}
	
	/******************* Template *******************/
	@RequestMapping(value="/user/viewTemplate",method=RequestMethod.GET)
	public ModelAndView viewUserTemplate(@ModelAttribute TemplateVO templateVO,
			@RequestParam String characterId,HttpSession session){
		session.setAttribute("characterId", characterId);
		System.out.println("characterId : : " + characterId);
		List templateList=this.templateService.search();
		return new ModelAndView("/user/viewStoryTemplate","templateList",templateList);
	}
	
	/******************* Create Story *******************/
	@RequestMapping(value="/user/viewCreateStory",method=RequestMethod.GET)
	public ModelAndView viewCreateStory(@RequestParam String rows,
			@RequestParam String cols,HttpSession session,
			@ModelAttribute BackgroundVO backgroundVO,@ModelAttribute CharacterVO characterVO
			,@ModelAttribute TemplateVO templateVO,@RequestParam int templateId){
		
		String backgroundId = (String) session.getAttribute("backgroundId");
		String characterId = (String) session.getAttribute("characterId");
		
		backgroundVO.setId(Integer.parseInt(backgroundId));
		characterVO.setId(Integer.parseInt(characterId));
		
		List backgroundList = backgroundService.edit(backgroundVO);
		List characterList = characterService.edit(characterVO);
		
		session.setAttribute("templateId", templateId);
		
		return new ModelAndView("/user/viewCreateStory","BackgroundVO",(BackgroundVO)backgroundList.get(0))
				.addObject("CharacterVO",(CharacterVO)characterList.get(0))
				.addObject("rows",rows)
				.addObject("cols",cols);
	}
	
	@RequestMapping(value="/user/insertStory",method=RequestMethod.POST)
	public ModelAndView insertStory(@ModelAttribute StoryVO storyVO,TemplateVO templateVO,BackgroundVO backgroundVO,CharacterVO characterVO,HttpSession session){
		
		Integer templateId = (Integer) session.getAttribute("templateId");
		String backgroundId = (String) session.getAttribute("backgroundId");
		String characterId = (String) session.getAttribute("characterId");
		
		storyVO.setStatus(true);
		
		String userName = Basemethods.getUser();
		List loginList = this.loginService.searchLoginID(userName);
		
		LoginVO loginVO = (LoginVO)loginList.get(0);
		templateVO.setId(templateId);
		characterVO.setId(Integer.parseInt(characterId));
		backgroundVO.setId(Integer.parseInt(backgroundId));
		
		storyVO.setLoginVO(loginVO);
		storyVO.setTemplateVO(templateVO);
		storyVO.setBackgroundVO(backgroundVO);
		storyVO.setCharacterVO(characterVO);
		
		this.storyService.insert(storyVO);
		
		return new ModelAndView("redirect:/user/index");
	}
	
	
	@RequestMapping(value="/user/viewOwnStory",method=RequestMethod.GET)
	public ModelAndView viewOwnStory(@ModelAttribute StoryVO storyVO ,HttpSession session){
		
		String userName = Basemethods.getUser();
		List loginList = this.loginService.searchLoginID(userName);
	
		LoginVO loginVO = (LoginVO)loginList.get(0);
		
		storyVO.setLoginVO(loginVO);
		List storyList  = this.storyService.viewOwnStory(storyVO);
		
		return new ModelAndView("/user/viewOwnStory","storyList",storyList);
	}

	@RequestMapping(value="/user/genereteStory",method=RequestMethod.GET)
	public ModelAndView genereteStory(@ModelAttribute StoryVO storyVO,@RequestParam String storyID){
		storyVO.setId(Integer.parseInt(storyID));
		List storyList  = this.storyService.genereteStory(storyVO);
		return new ModelAndView("/user/genereteStory","storyList",(StoryVO)storyList.get(0));
	}

}







