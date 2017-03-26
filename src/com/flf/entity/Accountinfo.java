package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>AccountinfoEntity<br>
 */
public class Accountinfo{
	
	private Page page;//分页用
	
		private java.lang.Long id;//   	/*private java.lang.Long customerId;//   	private java.lang.Long userId;//   */	private BigDecimal train;//   	private BigDecimal traout;//   	private BigDecimal traowner;//   	private java.util.Date operatedate;//   	private java.lang.String khyj;//   	private java.lang.String sfck;//   	private java.lang.String zjpassword;//   	private java.lang.String jypassword;// 
	private User user;
	private Customer customer;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public java.lang.Long getId() {	    return this.id;	}	public void setId(java.lang.Long id) {	    this.id=id;	}	/*public java.lang.Long getCustomerId() {	    return this.customerId;	}	public void setCustomerId(java.lang.Long customerId) {	    this.customerId=customerId;	}	public java.lang.Long getUserId() {	    return this.userId;	}	public void setUserId(java.lang.Long userId) {	    this.userId=userId;	}*/		public java.util.Date getOperatedate() {	    return this.operatedate;	}	public BigDecimal getTrain() {
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
	public void setOperatedate(java.util.Date operatedate) {	    this.operatedate=operatedate;	}	public java.lang.String getKhyj() {	    return this.khyj;	}	public void setKhyj(java.lang.String khyj) {	    this.khyj=khyj;	}	public java.lang.String getSfck() {	    return this.sfck;	}	public void setSfck(java.lang.String sfck) {	    this.sfck=sfck;	}	public java.lang.String getZjpassword() {	    return this.zjpassword;	}	public void setZjpassword(java.lang.String zjpassword) {	    this.zjpassword=zjpassword;	}	public java.lang.String getJypassword() {	    return this.jypassword;	}	public void setJypassword(java.lang.String jypassword) {	    this.jypassword=jypassword;	}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}

