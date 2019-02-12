package com.project.dao;

import java.util.List;

import com.project.model.SubCategoryVO;

public interface SubCategoryDAO {

	public void insert(SubCategoryVO subCategoryVO);

	public List search();

	public List edit(SubCategoryVO subCategoryVO);

}
