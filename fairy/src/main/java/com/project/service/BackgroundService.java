package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BackgroundDAO;
import com.project.model.BackgroundVO;

@Service
public class BackgroundService {

	@Autowired
	BackgroundDAO backgroundDAO;
	
	@Transactional
	public void insert(BackgroundVO backgroundVO) {
		this.backgroundDAO.insert(backgroundVO);
	}

	@Transactional
	public List search() {
		List backgroundList = this.backgroundDAO.search();
		return backgroundList;
	}

	@Transactional
	public List edit(BackgroundVO backgroundVO) {
		List backgroundList = this.backgroundDAO.edit(backgroundVO);
		return backgroundList;
	}

	@Transactional
	public List searchBysubCategory(BackgroundVO backgroundVO) {
		List backgroundList = this.backgroundDAO.searchBysubCategory(backgroundVO);
		return backgroundList;
	}

}
