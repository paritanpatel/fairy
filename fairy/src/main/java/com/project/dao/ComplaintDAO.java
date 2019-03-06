package com.project.dao;

import java.util.List;

import com.project.model.ComplaintVO;

public interface ComplaintDAO {

	public void insertComplaint(ComplaintVO complaintVO);

	public List viewComplaint();

	public List searchComplaint(ComplaintVO complaintVO);

	public List viewUserComplaint(ComplaintVO complaintVO);

}
