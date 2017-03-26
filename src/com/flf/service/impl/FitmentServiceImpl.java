package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.Fitment;
import com.flf.mapper.FitmentMapper;
import com.flf.service.FitmentService;

/**
 * 
 * <br>
 * <b>功能：</b>FitmentService<br>
 */
public class  FitmentServiceImpl implements FitmentService {
	private final static Logger log= Logger.getLogger(FitmentServiceImpl.class);
	

	private FitmentMapper fitmentMapper;
	
	//新增
	public void add(Fitment fitment){
		fitmentMapper.add(fitment);
	}
	//修改
	public void update(Fitment fitment){
		fitmentMapper.update(fitment);
	}
	//选择修改
	public void updateBySelective(Fitment fitment){
		fitmentMapper.updateBySelective(fitment);
	}	
	//删除记录
	public void delete(Object id){
		fitmentMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Fitment fitment){
		return fitmentMapper.queryByCount(fitment);
	}
	//查询列表
	public List<Fitment> queryByList(Fitment fitment){
		return fitmentMapper.queryByList(fitment);
	}
	
	//返回单个记录
	public Fitment queryById(Object id){
		return fitmentMapper.queryById(id);
	}

	public FitmentMapper getFitmentMapper() {
		return fitmentMapper;
	}

	public void setFitmentMapper(FitmentMapper fitmentMapper) {
		this.fitmentMapper = fitmentMapper;
	}
}
