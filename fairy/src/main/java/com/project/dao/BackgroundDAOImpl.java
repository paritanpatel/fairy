package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.BackgroundVO;

@Repository
public class BackgroundDAOImpl implements BackgroundDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(BackgroundVO backgroundVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(backgroundVO);
	}
	
	public List search(){
		List backgroundList = new ArrayList();		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from BackgroundVO where status = true " );
			backgroundList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return backgroundList;
	}
	
	public List edit(BackgroundVO backgroundVO){
		
		List backgroundList = new ArrayList();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from BackgroundVO where id='"+backgroundVO.getId()+"'");
			backgroundList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return backgroundList;
	}
}
