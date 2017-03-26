package com.flf.service;

import java.util.List;
import com.flf.entity.Accountinfo;
/**
 * 
 * <br>
 * <b>功能：</b>AccountinfoService<br>
 */
public interface AccountinfoService{
	//新增
	public void add(Accountinfo accountinfo);
	//修改
	public void update(Accountinfo accountinfo);
	//选择修改
	public void updateBySelective(Accountinfo accountinfo); 	
	//删除记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Accountinfo accountinfo);
	//查询列表
	public List<Accountinfo> queryByList(Accountinfo accountinfo);
	//返回单个记录
	public Accountinfo queryById(Object id);
}
