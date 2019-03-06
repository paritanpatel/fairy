package com.project.dao;

import java.util.List;

import com.project.model.SubCategoryVO;

public interface SubCategoryDAO {

	public void insert(SubCategoryVO subCategoryVO);

	public List search(SubCategoryVO subCategoryVO);

	public List edit(SubCategoryVO subCategoryVO);

	public List searchBycategory(SubCategoryVO subCategoryVO);

}
