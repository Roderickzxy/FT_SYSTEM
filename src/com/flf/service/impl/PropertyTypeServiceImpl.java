package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.PropertyType;
import com.flf.mapper.PropertyTypeMapper;
import com.flf.service.PropertyTypeService;

/**
 * 
 * <br>
 * <b>功能：</b>PropertyTypeService<br>
 */
public class  PropertyTypeServiceImpl implements PropertyTypeService {
	private final static Logger log= Logger.getLogger(PropertyTypeServiceImpl.class);
	

	private PropertyTypeMapper propertyTypeMapper;
	
	//新增
	public void add(PropertyType propertyType){
		propertyTypeMapper.add(propertyType);
	}
	//修改
	public void update(PropertyType propertyType){
		propertyTypeMapper.update(propertyType);
	}
	//选择修改
	public void updateBySelective(PropertyType propertyType){
		propertyTypeMapper.updateBySelective(propertyType);
	}	
	//删除记录
	public void delete(Object id){
		propertyTypeMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(PropertyType propertyType){
		return propertyTypeMapper.queryByCount(propertyType);
	}
	//查询列表
	public List<PropertyType> queryByList(PropertyType propertyType){
		return propertyTypeMapper.queryByList(propertyType);
	}
	
	//返回单个记录
	public PropertyType queryById(Object id){
		return propertyTypeMapper.queryById(id);
	}

	public PropertyTypeMapper getPropertyTypeMapper() {
		return propertyTypeMapper;
	}

	public void setPropertyTypeMapper(PropertyTypeMapper propertyTypeMapper) {
		this.propertyTypeMapper = propertyTypeMapper;
	}
}
