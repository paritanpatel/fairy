package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.SubCategoryDAO;
import com.project.model.SubCategoryVO;
@Service
public class SubCategoryService {

	@Autowired
	SubCategoryDAO subCategoryDAO;
	
	@Transactional
	public void insert(SubCategoryVO subCategoryVO) {
		this.subCategoryDAO.insert(subCategoryVO);
	}

	@Transactional
	public List search(SubCategoryVO subCategoryVO) {
		List subcategoryList = this.subCategoryDAO.search(subCategoryVO);
		return subcategoryList;
	}

	@Transactional
	public List edit(SubCategoryVO subCategoryVO) {

		List subcategoryList = this.subCategoryDAO.edit(subCategoryVO);
		return subcategoryList;
	}

	@Transactional
	public List searchBycategory(SubCategoryVO subCategoryVO) {
		List subcategoryList = this.subCategoryDAO.searchBycategory(subCategoryVO);
		return subcategoryList;
	}

}
