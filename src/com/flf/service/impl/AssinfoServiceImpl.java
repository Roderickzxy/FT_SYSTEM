package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.Assinfo;
import com.flf.mapper.AssinfoMapper;
import com.flf.service.AssinfoService;

/**
 * 
 * <br>
 * <b>功能：</b>AssinfoService<br>
 */
public class  AssinfoServiceImpl implements AssinfoService {
	private final static Logger log= Logger.getLogger(AssinfoServiceImpl.class);
	

	private AssinfoMapper assinfoMapper;
	
	//新增
	public void add(Assinfo assinfo){
		assinfoMapper.add(assinfo);
	}
	//修改
	public void update(Assinfo assinfo){
		assinfoMapper.update(assinfo);
	}
	//选择修改
	public void updateBySelective(Assinfo assinfo){
		assinfoMapper.updateBySelective(assinfo);
	}	
	//删除记录
	public void delete(Object id){
		assinfoMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Assinfo assinfo){
		return assinfoMapper.queryByCount(assinfo);
	}
	//查询列表
	public List<Assinfo> queryByList(Assinfo assinfo){
		return assinfoMapper.queryByList(assinfo);
	}
	
	//返回单个记录
	public Assinfo queryById(Object id){
		return assinfoMapper.queryById(id);
	}

	public AssinfoMapper getAssinfoMapper() {
		return assinfoMapper;
	}

	public void setAssinfoMapper(AssinfoMapper assinfoMapper) {
		this.assinfoMapper = assinfoMapper;
	}
}
