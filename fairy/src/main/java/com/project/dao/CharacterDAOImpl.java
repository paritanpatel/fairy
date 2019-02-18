package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CharacterVO;

@Repository
public class CharacterDAOImpl implements CharacterDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(CharacterVO characterVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(characterVO);
	}
	
	public List search(){
		List characterList = new ArrayList();		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from CharacterVO where status = true " );
			characterList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return characterList;
	}
	
	public List edit(CharacterVO characterVO){
		List characterList = new ArrayList();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery("from CharacterVO where id='"+characterVO.getId()+"'");
			characterList = q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return characterList;
	}
	
}
