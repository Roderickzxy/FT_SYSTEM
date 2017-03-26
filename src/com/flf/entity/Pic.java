package com.flf.entity;

public class Pic {
	private Integer id;//房源图片ID
	private Integer houseResourceID;//房源ID
	private String pic;//图片地址
	private String title;//标题
	private String descripse;//描述
	private String status;//启用状态 1--启用，0--停用
	private Integer msgId;//新闻ID
	private Integer picTypeId;////图片分类：客厅，厨房，卫生间，阳台，周边环境
	private Integer priority;//优先级
	private Integer figure;//推荐到首页
	
	//显示列表时读外键对象属性用
//	private HouseResource houseResource;
	private PicType picType;
	private Msg msg;
	//分页用
	private Page page;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHouseResourceID() {
		return houseResourceID;
	}
	public void setHouseResourceID(Integer houseResourceID) {
		this.houseResourceID = houseResourceID;
	}
	public Integer getFigure() {
		return figure;
	}
	public void setFigure(Integer figure) {
		this.figure = figure;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescripse() {
		return descripse;
	}
	public void setDescripse(String descripse) {
		this.descripse = descripse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public Integer getPicTypeId() {
		return picTypeId;
	}
	public void setPicTypeId(Integer picTypeId) {
		this.picTypeId = picTypeId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
//	public HouseResource getHouseResource() {
//		return houseResource;
//	}
//	public void setHouseResource(HouseResource houseResource) {
//		this.houseResource = houseResource;
//	}
	public PicType getPicType() {
		return picType;
	}
	public void setPicType(PicType picType) {
		this.picType = picType;
	}
	public Msg getMsg() {
		return msg;
	}
	public void setMsg(Msg msg) {
		this.msg = msg;
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
