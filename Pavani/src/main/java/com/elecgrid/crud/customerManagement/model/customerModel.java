package com.elecgrid.crud.customerManagement.model;

public class customerModel {

	private int cus_id;
	private String cus_name;
	private String cus_mobile;
	private String cus_email;
	
	public customerModel() {
		
	}
	
	public customerModel(int cus_id,String cus_name, String cus_mobile, String cus_email) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_mobile = cus_mobile;
		this.cus_email = cus_email;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_mobile() {
		return cus_mobile;
	}

	public void setCus_mobile(String cus_mobile) {
		this.cus_mobile = cus_mobile;
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
}
