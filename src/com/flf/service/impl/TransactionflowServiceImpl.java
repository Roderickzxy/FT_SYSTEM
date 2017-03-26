package com.flf.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flf.entity.Transactionflow;
import com.flf.mapper.TransactionflowMapper;
import com.flf.service.TransactionflowService;

/**
 * 
 * <br>
 * <b>功能：</b>TransactionflowService<br>
 */
public class  TransactionflowServiceImpl implements TransactionflowService {
	private final static Logger log= Logger.getLogger(TransactionflowServiceImpl.class);
	

	private TransactionflowMapper transactionflowMapper;
	
	//新增
	public void add(Transactionflow transactionflow){
		transactionflowMapper.add(transactionflow);
	}
	//修改
	public void update(Transactionflow transactionflow){
		transactionflowMapper.update(transactionflow);
	}
	//选择修改
	public void updateBySelective(Transactionflow transactionflow){
		transactionflowMapper.updateBySelective(transactionflow);
	}	
	//删除记录
	public void delete(Object id){
		transactionflowMapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(Transactionflow transactionflow){
		return transactionflowMapper.queryByCount(transactionflow);
	}
	//查询列表
	public List<Transactionflow> queryByList(Transactionflow transactionflow){
		return transactionflowMapper.queryByList(transactionflow);
	}
	
	//返回单个记录
	public Transactionflow queryById(Object id){
		return transactionflowMapper.queryById(id);
	}

	public TransactionflowMapper getTransactionflowMapper() {
		return transactionflowMapper;
	}

	public void setTransactionflowMapper(TransactionflowMapper transactionflowMapper) {
		this.transactionflowMapper = transactionflowMapper;
	}
}
