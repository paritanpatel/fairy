package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CategoryVO;
import com.project.model.CharacterVO;
import com.project.model.SubCategoryVO;
import com.project.service.CategoryService;
import com.project.service.CharacterService;
import com.project.service.SubCategoryService;

@Controller
public class CharacterController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	CharacterService characterService;
	
	@RequestMapping(value="/admin/loadCharacter",method=RequestMethod.GET)
	public ModelAndView loadCharacter(@ModelAttribute CategoryVO categoryVO,SubCategoryVO subCategoryVO)
	{
		List categoryList = this.categoryService.search();
		List subcategoryList = this.subCategoryService.search(subCategoryVO);
		
		return new ModelAndView("/admin/addCharacter","CharacterVO",new CharacterVO()).addObject("categoryList",categoryList).addObject("subcategoryList",subcategoryList);
	}
	
	@RequestMapping(value="/user/loadUserCharacter",method=RequestMethod.GET)
	public ModelAndView loadUserCharacter(@ModelAttribute CategoryVO categoryVO,SubCategoryVO subCategoryVO)
	{
		List categoryList = this.categoryService.search();
		List subcategoryList = this.subCategoryService.search(subCategoryVO);
		
		return new ModelAndView("/user/addCharacter","CharacterVO",new CharacterVO()).addObject("categoryList",categoryList).addObject("subcategoryList",subcategoryList);
	}
	
	@RequestMapping(value="/admin/insertCharacter",method=RequestMethod.POST)
	public ModelAndView insertCharacter(@ModelAttribute CharacterVO characterVO,@RequestParam("file") MultipartFile file,HttpSession session)
	{
		String path = session.getServletContext().getRealPath("/");
		String finalPath = path+"//document//character//";
		String fileName = file.getOriginalFilename();
		
		try 
		{
			byte[] b = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(finalPath+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		characterVO.setCharacterFileName(fileName);
		characterVO.setCharacterFilePath(finalPath);
		
		this.characterService.insert(characterVO);
		return new ModelAndView("redirect:/admin/viewCharacter");
	}
	
	@RequestMapping(value="/user/insertUserCharacter",method=RequestMethod.POST)
	public ModelAndView insertUserCharacter(@ModelAttribute CharacterVO characterVO,@RequestParam("file") MultipartFile file,HttpSession session)
	{
		String path = session.getServletContext().getRealPath("/");
		String finalPath = path+"//document//character//";
		String fileName = file.getOriginalFilename();
		
		try 
		{
			byte[] b = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(finalPath+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		characterVO.setCharacterFileName(fileName);
		characterVO.setCharacterFilePath(finalPath);
		
		this.characterService.insert(characterVO);
		return new ModelAndView("redirect:/user/viewUserCharacter");
	}
	
	
	@RequestMapping(value="/admin/viewCharacter",method=RequestMethod.GET)
	public ModelAndView viewCharacter(){
		List characterList = this.characterService.search();
		return new ModelAndView("/admin/viewCharacter","characterList",characterList);
	}
	@RequestMapping(value="/user/viewUserCharacter",method=RequestMethod.GET)
	public ModelAndView viewUserCharacter(@ModelAttribute CharacterVO characterVO){
		List characterList = this.characterService.search();
		return new ModelAndView("/user/viewCharacter","characterList",characterList);
	}
	
	@RequestMapping(value="/admin/deleteCharacter",method=RequestMethod.GET)
	public ModelAndView deleteCharacter(@ModelAttribute CharacterVO characterVO,@RequestParam String CharacterId){
		
		characterVO.setId((Integer.parseInt(CharacterId)));
		List characterList = this.characterService.edit(characterVO);
		
		CharacterVO characterVO2= (CharacterVO) characterList.get(0);
		characterVO2.setStatus(false);
		
		this.characterService.insert(characterVO2);
		
		return new ModelAndView("redirect:/admin/viewCharacter");
		
	} 
	
	@RequestMapping(value="/admin/editCharacter",method=RequestMethod.GET)
	public ModelAndView editSubCategory(@ModelAttribute CategoryVO categoryVO,@ModelAttribute SubCategoryVO subCategoryVO,@ModelAttribute CharacterVO characterVO,@RequestParam String CharacterId)
	{
		characterVO.setId((Integer.parseInt(CharacterId)));

		List characterList=this.characterService.edit(characterVO);
		CharacterVO characterVO2= (CharacterVO) characterList.get(0);
		
		List categoryList = this.categoryService.search();
		List subcategoryList = this.subCategoryService.search(subCategoryVO);
		return new ModelAndView("/admin/addCharacter","CharacterVO",characterVO2).addObject("categoryList",categoryList).addObject("subcategoryList",subcategoryList);		
	}

}

