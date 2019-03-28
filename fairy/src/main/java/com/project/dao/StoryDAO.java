package com.project.dao;

import java.util.List;

import com.project.model.StoryVO;

public interface StoryDAO {

	public void insert(StoryVO storyVO);

	public List search(StoryVO storyVO);

	public List genereteStory(StoryVO storyVO);

}
