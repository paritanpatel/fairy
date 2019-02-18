package com.project.dao;

import java.util.List;

import com.project.model.TemplateVO;

public interface TemplateDAO 
{

	public void insert(TemplateVO templateVO);

	public List search();

	public List edit(TemplateVO templateVO);

}
