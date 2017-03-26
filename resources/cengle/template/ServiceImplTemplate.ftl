package ${bussPackage}.service.impl#if($!entityPackage).${entityPackage}#end;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${bussPackage}.entity.${className};
import ${bussPackage}.mapper.${className}Mapper;
import ${bussPackage}.service.${className}Service;

/**
 * 
 * <br>
 * <b>功能：</b>${className}Service<br>
 */
public class  ${className}ServiceImpl implements ${className}Service {
	private final static Logger log= Logger.getLogger(${className}ServiceImpl.class);
	

	private ${className}Mapper ${lowerName}Mapper;
	
	//新增
	public void add(${className} ${lowerName}){
		${lowerName}Mapper.add(${lowerName});
	}
	//修改
	public void update(${className} ${lowerName}){
		${lowerName}Mapper.update(${lowerName});
	}
	//选择修改
	public void updateBySelective(${className} ${lowerName}){
		${lowerName}Mapper.updateBySelective(${lowerName});
	}	
	//删除记录
	public void delete(Object id){
		${lowerName}Mapper.delete(id);
	}
	//按条件查询记录数
	public int queryByCount(${className} ${lowerName}){
		return ${lowerName}Mapper.queryByCount(${lowerName});
	}
	//查询列表
	public List<${className}> queryByList(${className} ${lowerName}){
		return ${lowerName}Mapper.queryByList(${lowerName});
	}
	
	//返回单个记录
	public ${className} queryById(Object id){
		return ${lowerName}Mapper.queryById(id);
	}

	public ${className}Mapper get${className}Mapper() {
		return ${lowerName}Mapper;
	}

	public void set${className}Mapper(${className}Mapper ${lowerName}Mapper) {
		this.${lowerName}Mapper = ${lowerName}Mapper;
	}
}
