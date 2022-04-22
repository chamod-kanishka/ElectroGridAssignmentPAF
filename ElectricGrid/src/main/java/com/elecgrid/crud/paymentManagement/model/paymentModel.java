package com.elecgrid.crud.paymentManagement.model;

public class paymentModel {
	
	private int pay_id;
	private String pay_type;
	private String card_no;
	private double amount;
	
	public paymentModel() {
			
	}
	
	public paymentModel(int pay_id,String pay_type, String card_no, double amount) {
		super();
		this.pay_id = pay_id;
		this.pay_type = pay_type;
		this.card_no = card_no;
		this.amount = amount;
	}

	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
