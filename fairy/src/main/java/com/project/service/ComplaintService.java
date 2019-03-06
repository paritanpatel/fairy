package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ComplaintDAO;
import com.project.model.ComplaintVO;

@Service
public class ComplaintService {
	
	@Autowired
	ComplaintDAO complaintDAO ;

	@Transactional
	public void insertComplaint(ComplaintVO complaintVO) {
		this.complaintDAO.insertComplaint(complaintVO);		
	}

	@Transactional
	public List viewComplaint() {
		List complaintList = this.complaintDAO.viewComplaint();
		return complaintList;
	}

	@Transactional
	public List searchComplaint(ComplaintVO complaintVO) {
		List complaintList = this.complaintDAO.searchComplaint(complaintVO);
		return complaintList;
	}

	@Transactional
	public List viewUserComplaint(ComplaintVO complaintVO) {
		List complainList =	this.complaintDAO.viewUserComplaint(complaintVO);
        return complainList;	}

}
