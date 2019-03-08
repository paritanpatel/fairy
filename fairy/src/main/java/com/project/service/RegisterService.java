package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.RegisterDAO;
import com.project.model.LoginVO;
import com.project.model.RegisterVO;

@Service
public class RegisterService {

	@Autowired
	RegisterDAO registerDAO;
	
	@Transactional
	public void registerInsert(RegisterVO registerVO){
		this.registerDAO.registerInsert(registerVO);
	}

	@Transactional
	public List searchUser(LoginVO loginVO) {
		List userList = registerDAO.searchUser(loginVO);
		return userList;
	}
}
