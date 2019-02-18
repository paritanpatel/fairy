package com.project.dao;

import java.util.List;

import com.project.model.CharacterVO;

public interface CharacterDAO 
{
	public void insert(CharacterVO characterVO);

	public List search();

	public List edit(CharacterVO characterVO);
}
