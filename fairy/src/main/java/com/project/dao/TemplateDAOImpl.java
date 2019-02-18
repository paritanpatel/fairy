package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.TemplateVO;

@Repository
public class TemplateDAOImpl implements TemplateDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(TemplateVO templateVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(templateVO);
	}
	
	public List search(){
		List templateList = new ArrayList();		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from TemplateVO where status = true " );
			templateList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return templateList;
	}
	
	public List edit(TemplateVO templateVO)
	{
		List templateList = new ArrayList();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from TemplateVO where id='"+templateVO.getId()+"'");
			templateList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return templateList;
	
	}

}
