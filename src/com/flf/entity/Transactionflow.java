package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>TransactionflowEntity<br>
 */
public class Transactionflow{
	
	private Page page;//分页用
	
		private java.lang.Long id;//   	private java.util.Date tradate;//   	private java.sql.Timestamp tratime;//   	private java.lang.String bankname;//   	private java.lang.String operate;//   	private java.lang.String curtype;//   	private BigDecimal amount;//   	private java.lang.String status;//
	private String customerId;
	private java.util.Date startTradate;//   创建时间区间开始
	private java.util.Date endTradate;//   创建时间区间结束
		public java.util.Date getStartTradate() {
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
	public java.lang.Long getId() {	    return this.id;	}	public void setId(java.lang.Long id) {	    this.id=id;	}	public java.util.Date getTradate() {	    return this.tradate;	}	public void setTradate(java.util.Date tradate) {	    this.tradate=tradate;	}	public java.sql.Timestamp getTratime() {	    return this.tratime;	}	public void setTratime(java.sql.Timestamp tratime) {	    this.tratime=tratime;	}	public java.lang.String getBankname() {	    return this.bankname;	}	public void setBankname(java.lang.String bankname) {	    this.bankname=bankname;	}	public java.lang.String getOperate() {	    return this.operate;	}	public void setOperate(java.lang.String operate) {	    this.operate=operate;	}	public java.lang.String getCurtype() {	    return this.curtype;	}	public void setCurtype(java.lang.String curtype) {	    this.curtype=curtype;	}	public BigDecimal getAmount() {	    return this.amount;	}	public void setAmount(BigDecimal amount) {	    this.amount=amount;	}	public java.lang.String getStatus() {	    return this.status;	}	public void setStatus(java.lang.String status) {	    this.status=status;	}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}

