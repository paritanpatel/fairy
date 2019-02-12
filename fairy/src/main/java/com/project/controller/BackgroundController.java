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

import com.project.model.BackgroundVO;
import com.project.model.CategoryVO;
import com.project.model.SubCategoryVO;
import com.project.service.BackgroundService;
import com.project.service.CategoryService;
import com.project.service.SubCategoryService;

@Controller
public class BackgroundController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	BackgroundService backgroundService;
	
	@RequestMapping(value="loadBackground",method=RequestMethod.GET)
	public ModelAndView loadBackground(@ModelAttribute CategoryVO categoryVO){
		List categoryList = this.categoryService.search();
		List subcategoryList = this.subCategoryService.search();		
		return new ModelAndView("admin/addBackground","BackgroundVO",new BackgroundVO()).
				addObject("categoryList",categoryList).
				addObject("subcategoryList",subcategoryList);
	}

	@RequestMapping(value="insertBackground",method=RequestMethod.POST)
	public ModelAndView insertBackground(@ModelAttribute BackgroundVO backgroundVO,@RequestParam("file") MultipartFile file,HttpSession session){
		
		
		String path = session.getServletContext().getRealPath("/");
		String finalPath = path+"//document//background//";
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
		
		backgroundVO.setBackgrounFileName(fileName);
		backgroundVO.setBackgrounFilePath(finalPath);
		
		this.backgroundService.insert(backgroundVO);
		return new ModelAndView("redirect:/viewBackground");
	}
	
	@RequestMapping(value="viewBackground",method=RequestMethod.GET)
	public ModelAndView viewBackground(@ModelAttribute BackgroundVO backgroundVO){
		
		List backgroundList = this.backgroundService.search();
		return new ModelAndView("admin/viewBackground","backgroundList",backgroundList);
	} 
	
	@RequestMapping(value="deleteBackground",method=RequestMethod.GET)
	public ModelAndView deleteBackground(@ModelAttribute BackgroundVO backgroundVO,@RequestParam String BackgroundId){
		
		backgroundVO.setId((Integer.parseInt(BackgroundId)));
		List backgroundList=this.backgroundService.edit(backgroundVO);
		
		BackgroundVO backgroundVO2= (BackgroundVO) backgroundList.get(0);
		backgroundVO2.setStatus(false);
		
		this.backgroundService.insert(backgroundVO2);
		
		return new ModelAndView("redirect:/viewBackground");
		
	}
	
	@RequestMapping(value="editBackground",method=RequestMethod.GET)
	public ModelAndView editBackground(@ModelAttribute BackgroundVO backgroundVO,@RequestParam String BackgroundId){
		backgroundVO.setId((Integer.parseInt(BackgroundId)));

		List backgroundList=this.backgroundService.edit(backgroundVO);
		BackgroundVO backgroundVO2= (BackgroundVO) backgroundList.get(0);
		
		List categoryList = this.categoryService.search();
		List subcategoryList = this.subCategoryService.search();		

		return new ModelAndView("/admin/addBackground","BackgroundVO",backgroundVO2).addObject("categoryList",categoryList).addObject("subcategoryList",subcategoryList);	
		
	}
}
