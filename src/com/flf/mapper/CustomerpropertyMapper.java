package com.flf.mapper;

import java.util.List;
import com.flf.entity.Customerproperty;

public interface CustomerpropertyMapper {
	//新增
	public void add(Customerproperty customerproperty);
	//修改
	public void update(Customerproperty customerproperty);
	//选择修改
	public void updateBySelective(Customerproperty customerproperty); 	
	//删除单条记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Customerproperty customerproperty);
	//查询列表
	public List<Customerproperty> queryByList(Customerproperty customerproperty);
	//返回单个记录
	public Customerproperty queryById(Object id);
}
