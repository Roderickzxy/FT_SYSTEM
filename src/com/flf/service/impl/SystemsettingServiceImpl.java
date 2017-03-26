package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.Systemsetting;
import com.flf.mapper.SystemsettingMapper;
import com.flf.service.SystemsettingService;

/**
 * 
 * <br>
 * <b>功能：</b>SystemsettingService<br>
 */
public class  SystemsettingServiceImpl implements SystemsettingService {
	private final static Logger log= Logger.getLogger(SystemsettingServiceImpl.class);
	

	private SystemsettingMapper systemsettingMapper;
	
	//新增
	public void add(Systemsetting systemsetting){
		systemsettingMapper.add(systemsetting);
	}
	//修改
	public void update(Systemsetting systemsetting){
		systemsettingMapper.update(systemsetting);
	}
	//选择修改
	public void updateBySelective(Systemsetting systemsetting){
		systemsettingMapper.updateBySelective(systemsetting);
	}	
	//删除记录
	public void delete(Object id){
		systemsettingMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Systemsetting systemsetting){
		return systemsettingMapper.queryByCount(systemsetting);
	}
	//查询列表
	public List<Systemsetting> queryByList(Systemsetting systemsetting){
		return systemsettingMapper.queryByList(systemsetting);
	}
	
	//返回单个记录
	public Systemsetting queryById(Object id){
		return systemsettingMapper.queryById(id);
	}

	public SystemsettingMapper getSystemsettingMapper() {
		return systemsettingMapper;
	}

	public void setSystemsettingMapper(SystemsettingMapper systemsettingMapper) {
		this.systemsettingMapper = systemsettingMapper;
	}
}
