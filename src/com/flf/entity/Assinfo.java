package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>AssinfoEntity<br>
 */
public class Assinfo{
	
	private Page page;//分页用
	
	
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
