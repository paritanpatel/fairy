package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CharacterDAO;
import com.project.model.CharacterVO;

@Service
public class CharacterService {

	@Autowired
	CharacterDAO characterDAO;
	
	@Transactional
	public void insert(CharacterVO characterVO)
	{
		this.characterDAO.insert(characterVO);
	}
	
	@Transactional
	public List search() 
	{
		List characterList = this.characterDAO.search();
		return characterList;
	}
	
	@Transactional
	public List edit(CharacterVO characterVO)
	{
		List characterList = this.characterDAO.edit(characterVO);
		return characterList;
	}

	@Transactional
	public List searchBysubCategory(CharacterVO characterVO) {
		List characterList = this.characterDAO.searchBysubCategory(characterVO);
		return characterList;
	}

}
