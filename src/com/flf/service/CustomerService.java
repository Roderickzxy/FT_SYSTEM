package com.flf.service;

import java.util.List;
import com.flf.entity.Customer;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerService<br>
 */
public interface CustomerService{
	//新增
	public Integer add(Customer customer);
	//修改
	public void update(Customer customer);
	//选择修改
	public void updateBySelective(Customer customer); 	
	//删除记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Customer customer);
	//查询列表
	public List<Customer> queryByList(Customer customer);
	//返回单个记录
	public Customer queryById(Object id);
}
