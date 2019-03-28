package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.project.model.ComplaintVO;
import com.project.model.LoginVO;
import com.project.service.ComplaintService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;

@Controller

public class ComplaintController {
	
		@Autowired
		ComplaintService complaintService;
		
		@Autowired
		LoginService loginService;
		
		@RequestMapping(value="/user/loadComplaint",method=RequestMethod.GET)
		public ModelAndView loadComplaint()
		{
			return new ModelAndView("user/addComplaint","ComplaintVO",new ComplaintVO());
		}

		@RequestMapping(value="/user/insertComplaint",method=RequestMethod.POST)
		public ModelAndView insertComplaint(@ModelAttribute ComplaintVO complaintVO, @RequestParam(name="file") MultipartFile file ,HttpSession session)
		{
			String path = session.getServletContext().getRealPath("/");
			String fileName = file.getOriginalFilename();
			
			String finalPath = path+"document/complaint/"; 
			
			try {
				byte b[] = file.getBytes();
				
				BufferedOutputStream bufferedOutputStream = 
				new BufferedOutputStream(new FileOutputStream(finalPath+fileName));
				bufferedOutputStream.write(b);
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Date d = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			String userName = Basemethods.getUser();

			List loginList  = loginService.searchLoginID(userName);
			
			LoginVO loginVO2 = (LoginVO) loginList.get(0);
			complaintVO.setLoginVO(loginVO2);
			complaintVO.setComplaintDate(dateFormat.format(d));
			complaintVO.setComplaintFileName(fileName);
			complaintVO.setComplaintFilePath(finalPath);
			complaintVO.setComplaintStatus("PENDING");
			this.complaintService.insertComplaint(complaintVO);
			return new ModelAndView("redirect:/user/loadComplaint");
			
		}
		
		@RequestMapping(value="/admin/viewComplaint",method=RequestMethod.GET)
		public ModelAndView viewComplaint(){
			
			List complaintList = this.complaintService.viewComplaint();
			
			return new ModelAndView("/admin/viewComplaint","complaintList",complaintList);
		}
		
		@RequestMapping(value="/admin/replytoUser",method=RequestMethod.GET)
		public ModelAndView loadReply(@RequestParam("id")int id,@ModelAttribute ComplaintVO complaintVO) {
			
			complaintVO.setId(id);
			
			List complaintList = this.complaintService.searchComplaint(complaintVO);
			
			return new ModelAndView("admin/addReply","complaintVO",complaintList.get(0));
		}
		
		@RequestMapping(value="admin/insertReply",method=RequestMethod.POST)
		public ModelAndView insertReply(@ModelAttribute ComplaintVO complaintVO){
			Date d = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			complaintVO.setReplyDate(dateFormat.format(d));
			complaintVO.setComplaintStatus("resolved");
			
			this.complaintService.insertComplaint(complaintVO);
			
			return new ModelAndView("redirect:/admin/viewComplaint");
			
		}
		
		@RequestMapping(value="user/viewUserComplaint",method=RequestMethod.GET)
		public ModelAndView viewUserComplaint(@ModelAttribute ComplaintVO complaintVO) {
			String userName = Basemethods.getUser();

			List loginList  = loginService.searchLoginID(userName);
	    	
			LoginVO loginVO2 = (LoginVO) loginList.get(0);
			
			complaintVO.setLoginVO(loginVO2);
			
			List complaintList = this.complaintService.viewUserComplaint(complaintVO);
			
			return new ModelAndView("/user/viewComplaint","complaintList",complaintList);
		}
		
		
}
