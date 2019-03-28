package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.StoryDAO;
import com.project.model.StoryVO;

@Service
public class StoryService {

	@Autowired
	StoryDAO storyDAO;
	
	@Transactional
	public void insert(StoryVO storyVO) {
		this.storyDAO.insert(storyVO);
	}
	
	@Transactional
	public List viewOwnStory(StoryVO storyVO) {
		List storyList = this.storyDAO.search(storyVO);
		return storyList;
	}

	@Transactional
	public List genereteStory(StoryVO storyVO) {
		List storyList = this.storyDAO.genereteStory(storyVO);
		return storyList;
	}

}
