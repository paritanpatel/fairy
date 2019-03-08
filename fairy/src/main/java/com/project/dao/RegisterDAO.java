package com.project.dao;

import java.util.List;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;

public interface RegisterDAO {

	public void registerInsert(RegisterVO registerVO);

	public List searchUser(LoginVO loginVO);
}
