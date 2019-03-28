package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.StoryVO;

@Repository
public class StoryDAOImpl implements StoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(StoryVO storyVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(storyVO);
	}
	
	public List search(StoryVO storyVO){
		List storyList = new ArrayList();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from StoryVO where loginVO = '"+storyVO.getLoginVO().getLoginId()+"' " );
			storyList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return storyList;

	}
	
	public List genereteStory(StoryVO storyVO){
		List storyList = new ArrayList();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from StoryVO where id = '"+storyVO.getId()+"' " );
			storyList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return storyList;
	}
}
