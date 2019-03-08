package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;

@Repository
public class RegisterDAOImpl implements RegisterDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void registerInsert(RegisterVO registerVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registerVO);
	}
	
	@Override
	public List searchUser(LoginVO loginVO){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegisterVO where loginVO = " + loginVO.getLoginId());
		List ls = q.list();
		return ls;
	}
	
}
