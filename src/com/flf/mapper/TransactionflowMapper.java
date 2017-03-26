package com.flf.mapper;

import java.util.List;
import com.flf.entity.Transactionflow;

public interface TransactionflowMapper {
	//新增
	public void add(Transactionflow transactionflow);
	//修改
	public void update(Transactionflow transactionflow);
	//选择修改
	public void updateBySelective(Transactionflow transactionflow); 	
	//删除单条记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(Transactionflow transactionflow);
	//查询列表
	public List<Transactionflow> queryByList(Transactionflow transactionflow);
	//返回单个记录
	public Transactionflow queryById(Object id);
}
