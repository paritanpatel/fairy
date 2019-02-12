package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="background_table")
public class BackgroundVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="backgroundName")
	private String backgroundName;
	
	@Column(name="backgroundFileName")
	private String backgrounFileName;

	@Column(name="backgroundFilePath")
	private String backgrounFilePath;

	
	@Column(name="status")
	private boolean status = true;

	@ManyToOne
	private CategoryVO categoryVO;
	
	@ManyToOne
	private SubCategoryVO subCategoryVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBackgroundName() {
		return backgroundName;
	}

	public void setBackgroundName(String backgroundName) {
		this.backgroundName = backgroundName;
	}

	public String getBackgrounFileName() {
		return backgrounFileName;
	}

	public void setBackgrounFileName(String backgrounFileName) {
		this.backgrounFileName = backgrounFileName;
	}

	public String getBackgrounFilePath() {
		return backgrounFilePath;
	}

	public void setBackgrounFilePath(String backgrounFilePath) {
		this.backgrounFilePath = backgrounFilePath;
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
	
}
