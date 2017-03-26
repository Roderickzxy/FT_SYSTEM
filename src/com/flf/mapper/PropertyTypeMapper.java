package com.flf.mapper;

import java.util.List;
import com.flf.entity.PropertyType;

public interface PropertyTypeMapper {
	//新增
	public void add(PropertyType propertyType);
	//修改
	public void update(PropertyType propertyType);
	//选择修改
	public void updateBySelective(PropertyType propertyType); 	
	//删除单条记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(PropertyType propertyType);
	//查询列表
	public List<PropertyType> queryByList(PropertyType propertyType);
	//返回单个记录
	public PropertyType queryById(Object id);
}
