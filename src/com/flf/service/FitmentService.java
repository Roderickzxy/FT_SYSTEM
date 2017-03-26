package com.flf.service;

import java.util.List;
import com.flf.entity.Fitment;
/**
 * 
 * <br>
 * <b>功能：</b>FitmentService<br>
 */
public interface FitmentService{
	//新增
	public void add(Fitment fitment);
	//修改
	public void update(Fitment fitment);
	//选择修改
	public void updateBySelective(Fitment fitment); 	
	//删除记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Fitment fitment);
	//查询列表
	public List<Fitment> queryByList(Fitment fitment);
	//返回单个记录
	public Fitment queryById(Object id);
}
