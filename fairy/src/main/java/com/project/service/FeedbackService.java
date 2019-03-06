package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FeedbackDAO;
import com.project.model.FeedbackVO;

@Service
public class FeedbackService {

	@Autowired
	FeedbackDAO feedbackDAO;
	
	@Transactional
	public void insertFeedback(FeedbackVO feedbackVO) {
		this.feedbackDAO.insertFeedback(feedbackVO);
	}

	@Transactional
	public List viewFeedback(FeedbackVO feedbackVO) {
		List feedbackList = this.feedbackDAO.viewFeedback(feedbackVO);
		return feedbackList;
	}

	@Transactional
	public List viewUserFeedback(FeedbackVO feedbackVO) {
		List feedbackList =	this.feedbackDAO.viewUserFeedback(feedbackVO);
        return feedbackList;
    }

}
