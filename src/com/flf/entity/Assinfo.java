package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>AssinfoEntity<br>
 */
public class Assinfo{
	
	private Page page;//分页用
	
		private java.lang.Long id;//   	private java.lang.String title;//   	private java.lang.String content;//   	private java.lang.String status;//   	private java.lang.String msgType;//   	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}	public java.lang.String getTitle() {	    return this.title;	}	public void setTitle(java.lang.String title) {	    this.title=title;	}	public java.lang.String getContent() {	    return this.content;	}	public void setContent(java.lang.String content) {	    this.content=content;	}	public java.lang.String getStatus() {	    return this.status;	}	public void setStatus(java.lang.String status) {	    this.status=status;	}	public java.lang.String getMsgType() {	    return this.msgType;	}	public void setMsgType(java.lang.String msgType) {	    this.msgType=msgType;	}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}

