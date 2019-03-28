package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="story_table")
public class StoryVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="message")
	private String message;
	
	@Column(name="status")
	private boolean status = true;

	@Column(name="storyName")
	private String storyName;
	
	@ManyToOne
	private LoginVO loginVO;

	@ManyToOne 
	private TemplateVO templateVO;

	
	@ManyToOne 
	private BackgroundVO backgroundVO;

	
	@ManyToOne 
	private CharacterVO characterVO;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public TemplateVO getTemplateVO() {
		return templateVO;
	}

	public void setTemplateVO(TemplateVO templateVO) {
		this.templateVO = templateVO;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public BackgroundVO getBackgroundVO() {
		return backgroundVO;
	}

	public void setBackgroundVO(BackgroundVO backgroundVO) {
		this.backgroundVO = backgroundVO;
	}

	public CharacterVO getCharacterVO() {
		return characterVO;
	}

	public void setCharacterVO(CharacterVO characterVO) {
		this.characterVO = characterVO;
	}
	

}
