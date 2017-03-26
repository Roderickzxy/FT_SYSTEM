package com.flf.service;

import java.util.List;
import com.flf.entity.Assinfo;
/**
 * 
 * <br>
 * <b>功能：</b>AssinfoService<br>
 */
public interface AssinfoService{
	//新增
	public void add(Assinfo assinfo);
	//修改
	public void update(Assinfo assinfo);
	//选择修改
	public void updateBySelective(Assinfo assinfo); 	
	//删除记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Assinfo assinfo);
	//查询列表
	public List<Assinfo> queryByList(Assinfo assinfo);
	//返回单个记录
	public Assinfo queryById(Object id);
}
