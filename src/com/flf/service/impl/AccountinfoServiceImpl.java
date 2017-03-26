package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.Accountinfo;
import com.flf.mapper.AccountinfoMapper;
import com.flf.service.AccountinfoService;

/**
 * 
 * <br>
 * <b>功能：</b>AccountinfoService<br>
 */
public class  AccountinfoServiceImpl implements AccountinfoService {
	private final static Logger log= Logger.getLogger(AccountinfoServiceImpl.class);
	

	private AccountinfoMapper accountinfoMapper;
	
	//新增
	public void add(Accountinfo accountinfo){
		accountinfoMapper.add(accountinfo);
	}
	//修改
	public void update(Accountinfo accountinfo){
		accountinfoMapper.update(accountinfo);
	}
	//选择修改
	public void updateBySelective(Accountinfo accountinfo){
		accountinfoMapper.updateBySelective(accountinfo);
	}	
	//删除记录
	public void delete(Object id){
		accountinfoMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Accountinfo accountinfo){
		return accountinfoMapper.queryByCount(accountinfo);
	}
	//查询列表
	public List<Accountinfo> queryByList(Accountinfo accountinfo){
		return accountinfoMapper.queryByList(accountinfo);
	}
	
	//返回单个记录
	public Accountinfo queryById(Object id){
		return accountinfoMapper.queryById(id);
	}

	public AccountinfoMapper getAccountinfoMapper() {
		return accountinfoMapper;
	}

	public void setAccountinfoMapper(AccountinfoMapper accountinfoMapper) {
		this.accountinfoMapper = accountinfoMapper;
	}
}
