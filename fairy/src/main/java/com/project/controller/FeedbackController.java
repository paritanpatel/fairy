package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.FeedbackVO;
import com.project.service.FeedbackService;

@Controller
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@RequestMapping(value="/user/loadFeedback",method=RequestMethod.GET)
	public ModelAndView loadFeedback(){
		return new ModelAndView("/user/addFeedback","feedbackVO",new FeedbackVO());
	}
	
	@RequestMapping(value="/user/insertFeedback",method=RequestMethod.POST)
	public ModelAndView insertFeedback(@ModelAttribute FeedbackVO feedbackVO){
		this.feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView("redirect:/user/loadFeedback");
	}
	
	@RequestMapping(value="admin/viewFeedback",method=RequestMethod.GET)
	public ModelAndView viewFeedback(@ModelAttribute FeedbackVO feedbackVO){
		List feedbackList = this.feedbackService.viewFeedback(feedbackVO);
		return new ModelAndView("admin/viewFeedback","feedbackList",feedbackList);
	}
	
	@RequestMapping(value="user/viewUserFeedback",method=RequestMethod.GET)
	public ModelAndView viewUserFeedback(@ModelAttribute FeedbackVO feedbackVO){
		List feedbackList = this.feedbackService.viewUserFeedback(feedbackVO);
		return new ModelAndView("/user/viewFeedback","feedbackList",feedbackList);
	}
}

