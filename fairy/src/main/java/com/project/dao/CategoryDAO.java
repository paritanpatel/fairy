package com.project.dao;


import java.util.List;

import com.project.model.CategoryVO;

public interface CategoryDAO {

	public void insert(CategoryVO categoryVO);

	public List search();

	public List edit(CategoryVO categoryVO);

}
