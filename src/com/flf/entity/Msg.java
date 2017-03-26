package com.flf.entity;

public class Msg {
	private Integer msgId;
	private String title;
	private String content;
	private String status;
	private String loginname;
	private String video;
	private String pic;
	private Integer msgTypeId;
	private Integer sytj;//推荐到首页
	private String descripse;
	
	private MsgType msgType;
	private Page page;
	
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getMsgTypeId() {
		return msgTypeId;
	}
	public void setMsgTypeId(Integer msgTypeId) {
		this.msgTypeId = msgTypeId;
	}
	
	public MsgType getMsgType() {
		return msgType;
	}
	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}
	public Integer getSytj() {
		return sytj;
	}
	public void setSytj(Integer sytj) {
		this.sytj = sytj;
	}
	public String getDescripse() {
		return descripse;
	}
	public void setDescripse(String descripse) {
		this.descripse = descripse;
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
