package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerpropertyEntity<br>
 */
public class Customerproperty{
	
	private Page page;//分页用
	
	
	private java.lang.String type;// 
*/	private Customer customer;


	return type;
}
public void setType(java.lang.String type) {
	this.type = type;
}
	public java.lang.Long getId() {
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
