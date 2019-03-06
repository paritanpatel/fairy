package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="category_table")
public class CategoryVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="categoryDescription")
	private String categoryDescription;


	@Column(name="categoryFileName")
	private String categoryFileName;

	@Column(name="categoryFilePath")
	private String categoryFilePath;

	
	private boolean status = true;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public  void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryFileName() {
		return categoryFileName;
	}

	public void setCategoryFileName(String categoryFileName) {
		this.categoryFileName = categoryFileName;
	}

	public String getCategoryFilePath() {
		return categoryFilePath;
	}

	public void setCategoryFilePath(String categoryFilePath) {
		this.categoryFilePath = categoryFilePath;
	}
	
	

}
