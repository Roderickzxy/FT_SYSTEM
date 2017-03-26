package com.flf.entity;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerEntity<br>
 */
public class Customer{
	
	private Page page;//分页用
	
		private java.lang.Long id;//   租客ID	private java.lang.String account;//   登录账号(必填)	private java.lang.String password;//   登录密码(必填)	private java.lang.String name;//   真实姓名(必填)	private java.lang.Integer sex;//   性别(必填,1-男，2-女)	private java.util.Date birth;//   出生年月(必填 yyyy-dd)	private java.lang.String idCardNum;//   身份证编号(必填)	private java.lang.String mobile;//   手机(必填)	private java.lang.String jobcode;//  职业代码	private java.lang.String xlcode;//   学历代码	private java.lang.String idCardType;//   证件类型	private java.lang.String address;//   联系地址	private java.lang.String emergencyContact;//   紧急联络人(必填)	private java.lang.String emergencyMobile;//   紧急联络电话(必填)	private java.lang.Integer isLocked;//   禁用状态（1-启用，2-停用）	private java.lang.Integer isFrozened;//   冻结状态（1-解冻，2-冻结）	private java.lang.String email;//   	private java.lang.String signcenter;//   	private java.lang.String fxlever;//   	private java.util.Date opendate;//   	private java.util.Date fxcpdate;//   	private java.util.Date fxdqdate;//   	private java.lang.String cashaccount;//   	private java.lang.String hucode;//   	private java.lang.String shencode;// 
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public java.lang.Long getId() {	    return this.id;	}	public void setId(java.lang.Long id) {	    this.id=id;	}	public java.lang.String getAccount() {	    return this.account;	}	public void setAccount(java.lang.String account) {	    this.account=account;	}	public java.lang.String getPassword() {	    return this.password;	}	public void setPassword(java.lang.String password) {	    this.password=password;	}	public java.lang.String getName() {	    return this.name;	}	public void setName(java.lang.String name) {	    this.name=name;	}	public java.lang.Integer getSex() {	    return this.sex;	}	public void setSex(java.lang.Integer sex) {	    this.sex=sex;	}	public java.util.Date getBirth() {	    return this.birth;	}	public void setBirth(java.util.Date birth) {	    this.birth=birth;	}	public java.lang.String getIdCardNum() {	    return this.idCardNum;	}	public void setIdCardNum(java.lang.String idCardNum) {	    this.idCardNum=idCardNum;	}	public java.lang.String getMobile() {	    return this.mobile;	}	public void setMobile(java.lang.String mobile) {	    this.mobile=mobile;	}	public java.lang.String getJobcode() {	    return this.jobcode;	}	public void setJobcode(java.lang.String jobcode) {	    this.jobcode=jobcode;	}	public java.lang.String getXlcode() {	    return this.xlcode;	}	public void setXlcode(java.lang.String xlcode) {	    this.xlcode=xlcode;	}	public java.lang.String getIdCardType() {	    return this.idCardType;	}	public void setIdCardType(java.lang.String idCardType) {	    this.idCardType=idCardType;	}	public java.lang.String getAddress() {	    return this.address;	}	public void setAddress(java.lang.String address) {	    this.address=address;	}	public java.lang.String getEmergencyContact() {	    return this.emergencyContact;	}	public void setEmergencyContact(java.lang.String emergencyContact) {	    this.emergencyContact=emergencyContact;	}	public java.lang.String getEmergencyMobile() {	    return this.emergencyMobile;	}	public void setEmergencyMobile(java.lang.String emergencyMobile) {	    this.emergencyMobile=emergencyMobile;	}	public java.lang.Integer getIsLocked() {	    return this.isLocked;	}	public void setIsLocked(java.lang.Integer isLocked) {	    this.isLocked=isLocked;	}	public java.lang.Integer getIsFrozened() {	    return this.isFrozened;	}	public void setIsFrozened(java.lang.Integer isFrozened) {	    this.isFrozened=isFrozened;	}	public java.lang.String getEmail() {	    return this.email;	}	public void setEmail(java.lang.String email) {	    this.email=email;	}	public java.lang.String getSigncenter() {	    return this.signcenter;	}	public void setSigncenter(java.lang.String signcenter) {	    this.signcenter=signcenter;	}	public java.lang.String getFxlever() {	    return this.fxlever;	}	public void setFxlever(java.lang.String fxlever) {	    this.fxlever=fxlever;	}	public java.util.Date getOpendate() {	    return this.opendate;	}	public void setOpendate(java.util.Date opendate) {	    this.opendate=opendate;	}	public java.util.Date getFxcpdate() {	    return this.fxcpdate;	}	public void setFxcpdate(java.util.Date fxcpdate) {	    this.fxcpdate=fxcpdate;	}	public java.util.Date getFxdqdate() {	    return this.fxdqdate;	}	public void setFxdqdate(java.util.Date fxdqdate) {	    this.fxdqdate=fxdqdate;	}	public java.lang.String getCashaccount() {	    return this.cashaccount;	}	public void setCashaccount(java.lang.String cashaccount) {	    this.cashaccount=cashaccount;	}	public java.lang.String getHucode() {	    return this.hucode;	}	public void setHucode(java.lang.String hucode) {	    this.hucode=hucode;	}	public java.lang.String getShencode() {	    return this.shencode;	}	public void setShencode(java.lang.String shencode) {	    this.shencode=shencode;	}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}

