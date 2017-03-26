package com.flf.mapper;

import java.util.List;
import com.flf.entity.Systemsetting;

public interface SystemsettingMapper {
	//新增
	public void add(Systemsetting systemsetting);
	//修改
	public void update(Systemsetting systemsetting);
	//选择修改
	public void updateBySelective(Systemsetting systemsetting); 	
	//删除单条记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Systemsetting systemsetting);
	//查询列表
	public List<Systemsetting> queryByList(Systemsetting systemsetting);
	//返回单个记录
	public Systemsetting queryById(Object id);
}
