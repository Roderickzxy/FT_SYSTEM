package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>AccountinfoEntity<br>
 */
public class Accountinfo{
	
	private Page page;//分页用
	
	
	private User user;
	private Customer customer;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public java.lang.Long getId() {
		return train;
	}
	public void setTrain(BigDecimal train) {
		this.train = train;
	}
	public BigDecimal getTraout() {
		return traout;
	}
	public void setTraout(BigDecimal traout) {
		this.traout = traout;
	}
	public BigDecimal getTraowner() {
		return traowner;
	}
	public void setTraowner(BigDecimal traowner) {
		this.traowner = traowner;
	}
	public void setOperatedate(java.util.Date operatedate) {
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
