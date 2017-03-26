package com.flf.entity;

import java.util.List;

//图片分类
public class PicType {
	
	private Integer id;
	private String name;
	private String code;
	private Integer parent;
	private PicType parentPicType;
	private List<PicType> subPicType;
	
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
	
	public PicType getParentPicType() {
		return parentPicType;
	}
	
	public void setParentPicType(PicType parentPicType) {
		this.parentPicType = parentPicType;
	}
	
	public List<PicType> getSubPicType() {
		return subPicType;
	}
	
	public void setSubPicType(List<PicType> subPicType) {
		this.subPicType = subPicType;
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
