package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>FitmentEntity<br>
 */
public class Fitment{
	
	private Page page;//分页用
	
		private java.lang.Long id;//   装修ID	private java.lang.String name;//   名称	private java.lang.String code;//   编码	private java.lang.String fittype;//   类别	public java.lang.Long getId() {	    return this.id;	}	public void setId(java.lang.Long id) {	    this.id=id;	}	public java.lang.String getName() {	    return this.name;	}	public void setName(java.lang.String name) {	    this.name=name;	}	public java.lang.String getCode() {	    return this.code;	}	public void setCode(java.lang.String code) {	    this.code=code;	}	public java.lang.String getFittype() {	    return this.fittype;	}	public void setFittype(java.lang.String fittype) {	    this.fittype=fittype;	}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}

