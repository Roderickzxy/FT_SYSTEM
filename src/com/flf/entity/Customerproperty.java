package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerpropertyEntity<br>
 */
public class Customerproperty{
	
	private Page page;//分页用
	
		private java.lang.Long id;//   	private java.lang.String name;//   	private java.lang.String code;//   	private java.lang.String fittype;//  
	private java.lang.String type;// 	/*private java.lang.Long customerId;//  
*/	private Customer customer;

	public java.lang.String getType() {
	return type;
}
public void setType(java.lang.String type) {
	this.type = type;
}
	public java.lang.Long getId() {	    return this.id;	}	public void setId(java.lang.Long id) {	    this.id=id;	}	public java.lang.String getName() {	    return this.name;	}	public void setName(java.lang.String name) {	    this.name=name;	}	public java.lang.String getCode() {	    return this.code;	}	public void setCode(java.lang.String code) {	    this.code=code;	}	public java.lang.String getFittype() {	    return this.fittype;	}	public void setFittype(java.lang.String fittype) {	    this.fittype=fittype;	}	/*public java.lang.Long getCustomerId() {	    return this.customerId;	}	public void setCustomerId(java.lang.Long customerId) {	    this.customerId=customerId;	}*/
	
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

