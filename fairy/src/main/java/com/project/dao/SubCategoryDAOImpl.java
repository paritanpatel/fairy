package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.SubCategoryVO;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(SubCategoryVO subCategoryVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(subCategoryVO);
	}
	
	public List search(){
		List categoryList = new ArrayList();		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from SubCategoryVO where status = true " );
			categoryList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return categoryList;
	}


}
