package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CategoryDAO;
import com.project.model.CategoryVO;

@Service
public class CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Transactional
	public void insert(CategoryVO categoryVO){
		this.categoryDAO.insert(categoryVO);
	}
	
	@Transactional
	public List search() {
		List categoryList = this.categoryDAO.search();
		return categoryList;		
	}

	@Transactional
	public List edit(CategoryVO categoryVO) {
		List categoryList = this.categoryDAO.edit(categoryVO);
		return categoryList;
	}

	
	
}
