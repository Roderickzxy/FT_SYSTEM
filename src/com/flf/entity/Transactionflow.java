package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>TransactionflowEntity<br>
 */
public class Transactionflow{
	
	private Page page;//分页用
	
	
	private String customerId;
	private java.util.Date startTradate;//   创建时间区间开始
	private java.util.Date endTradate;//   创建时间区间结束
	
		return startTradate;
	}
	public void setStartTradate(java.util.Date startTradate) {
		this.startTradate = startTradate;
	}
	public java.util.Date getEndTradate() {
		return endTradate;
	}
	public void setEndTradate(java.util.Date endTradate) {
		this.endTradate = endTradate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public java.lang.Long getId() {
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
