package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.TemplateDAO;
import com.project.model.TemplateVO;

@Service
public class TemplateService {
	
	@Autowired
	TemplateDAO templateDAO;

	@Transactional
	public void insert(TemplateVO templateVO)
	{
		this.templateDAO.insert(templateVO);	
	}

	@Transactional
	public List search() 
	{
		List templateList = this.templateDAO.search();
		return templateList;		
	}

	@Transactional
	public List edit(TemplateVO templateVO)
	{
		List templateList = this.templateDAO.edit(templateVO);
		return templateList;
	}

}
