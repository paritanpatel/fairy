package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="character_table")

public class CharacterVO {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterFileName() {
		return characterFileName;
	}

	public void setCharacterFileName(String characterFileName) {
		this.characterFileName = characterFileName;
	}

	public String getCharacterFilePath() {
		return characterFilePath;
	}

	public void setCharacterFilePath(String characterFilePath) {
		this.characterFilePath = characterFilePath;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	public SubCategoryVO getSubCategoryVO() {
		return subCategoryVO;
	}

	public void setSubCategoryVO(SubCategoryVO subCategoryVO) {
		this.subCategoryVO = subCategoryVO;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="characterName")
	private String characterName;
	
	@Column(name="characterFileName")
	private String characterFileName;

	@Column(name="characterFilePath")
	private String characterFilePath;
	
	@Column(name="status")
	private boolean status = true;

	@ManyToOne
	private CategoryVO categoryVO;
	
	@ManyToOne
	private SubCategoryVO subCategoryVO;


}
