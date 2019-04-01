package com.pta.model;

import org.springframework.stereotype.Component;

@Component("billPOJO")
public class BillPOJO {
	private String billId;
	private String billDate;
	private int totalAmount;
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
