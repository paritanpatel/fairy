package com.project.dao;

import java.util.List;

import com.project.model.BackgroundVO;

public interface BackgroundDAO {

	public void insert(BackgroundVO backgroundVO);

	public List search();

	public List edit(BackgroundVO backgroundVO);

}
