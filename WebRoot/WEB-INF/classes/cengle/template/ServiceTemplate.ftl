package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end;

import java.util.List;
import ${bussPackage}.entity.${className};
/**
 * 
 * <br>
 * <b>功能：</b>${className}Service<br>
 */
public interface ${className}Service{
	//新增
	public void add(${className} ${lowerName});
	//修改
	public void update(${className} ${lowerName});
	//选择修改
	public void updateBySelective(${className} ${lowerName}); 	
	//删除记录
	public void delete(Object id);
	//按条件查询记录数
	public int queryByCount(${className} ${lowerName});
	//查询列表
	public List<${className}> queryByList(${className} ${lowerName});
	//返回单个记录
	public ${className} queryById(Object id);
}
