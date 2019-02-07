package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CategoryVO;

@Repository
public class CategoryDAOImp implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(CategoryVO categoryVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(categoryVO);
	}
	
	public List search(){
		List categoryList = new ArrayList();		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from CategoryVO where status = true " );
			categoryList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return categoryList;
	}
	
	
	public List edit(CategoryVO categoryVO){
		List categoryList = new ArrayList();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from CategoryVO where id='"+categoryVO.getId()+"'");
			categoryList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return categoryList;
		
	}
}

