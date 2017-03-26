package com.flf.entity;

import java.util.List;

//新闻类型分类
public class MsgType {
	
	private Integer id;
	private String name;
	private String code;
	private Integer parent;
	private MsgType parentMsgType;
	private List<MsgType> subMsgType;
	
	private Page page;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	public MsgType getParentMsgType() {
		return parentMsgType;
	}
	public void setParentMsgType(MsgType parentMsgType) {
		this.parentMsgType = parentMsgType;
	}
	public List<MsgType> getSubMsgType() {
		return subMsgType;
	}
	public void setSubMsgType(List<MsgType> subMsgType) {
		this.subMsgType = subMsgType;
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
