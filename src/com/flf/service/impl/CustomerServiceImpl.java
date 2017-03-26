package com.flf.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.flf.entity.Customer;
import com.flf.mapper.CustomerMapper;
import com.flf.service.CustomerService;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerService<br>
 */
public class  CustomerServiceImpl implements CustomerService {
	private final static Logger log= Logger.getLogger(CustomerServiceImpl.class);
	

	private CustomerMapper customerMapper;
	
	//新增
	public Integer add(Customer customer){
		return customerMapper.add(customer);
	}
	//修改
	public void update(Customer customer){
		customerMapper.update(customer);
	}
	//选择修改
	public void updateBySelective(Customer customer){
		customerMapper.updateBySelective(customer);
	}	
	//删除记录
	public void delete(Object id){
		customerMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Customer customer){
		return customerMapper.queryByCount(customer);
	}
	//查询列表
	public List<Customer> queryByList(Customer customer){
		return customerMapper.queryByList(customer);
	}
	
	//返回单个记录
	public Customer queryById(Object id){
		return customerMapper.queryById(id);
	}

	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}

	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
}
