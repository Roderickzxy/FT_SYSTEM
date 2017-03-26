package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.Customerproperty;
import com.flf.mapper.CustomerpropertyMapper;
import com.flf.service.CustomerpropertyService;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerpropertyService<br>
 */
public class  CustomerpropertyServiceImpl implements CustomerpropertyService {
	private final static Logger log= Logger.getLogger(CustomerpropertyServiceImpl.class);
	

	private CustomerpropertyMapper customerpropertyMapper;
	
	//新增
	public void add(Customerproperty customerproperty){
		customerpropertyMapper.add(customerproperty);
	}
	//修改
	public void update(Customerproperty customerproperty){
		customerpropertyMapper.update(customerproperty);
	}
	//选择修改
	public void updateBySelective(Customerproperty customerproperty){
		customerpropertyMapper.updateBySelective(customerproperty);
	}	
	//删除记录
	public void delete(Object id){
		customerpropertyMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Customerproperty customerproperty){
		return customerpropertyMapper.queryByCount(customerproperty);
	}
	//查询列表
	public List<Customerproperty> queryByList(Customerproperty customerproperty){
		return customerpropertyMapper.queryByList(customerproperty);
	}
	
	//返回单个记录
	public Customerproperty queryById(Object id){
		return customerpropertyMapper.queryById(id);
	}

	public CustomerpropertyMapper getCustomerpropertyMapper() {
		return customerpropertyMapper;
	}

	public void setCustomerpropertyMapper(CustomerpropertyMapper customerpropertyMapper) {
		this.customerpropertyMapper = customerpropertyMapper;
	}
}
