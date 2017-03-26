package com.flf.service.impl;

import java.util.List;
import com.flf.entity.Navigation;
import com.flf.mapper.NavigationMapper;
import com.flf.service.NavigationService;


public class NavigationServiceImpl implements NavigationService{
	
	private NavigationMapper navigationMapper;
	
	//删除一条记录
	public void deleteNavigationById(Integer id) {
		navigationMapper.deleteNavigationById(id);
	}
	
	//获取单条记录
	public Navigation getNavigationById(Integer id) {
		return navigationMapper.getNavigationById(id);
	}
	
	//修改记录
	public boolean updateNavigation(Navigation navigation) {
		if(navigationMapper.getCountNavigationByName(navigation)>0)
			return false;
		else{
			navigationMapper.updateNavigation(navigation);
			return true;
		}
	}
	
	//插入一条记录
	public boolean insertNavigation(Navigation navigation) {
		if(navigationMapper.getCountNavigationByName(navigation)>0)
			return false;
		else{
			navigationMapper.insertNavigation(navigation);
			return true;
		}
	}
	
	//获取所有有记录
	public List<Navigation> listAllNavigation() {
		return navigationMapper.listAllNavigation();
	}

	public NavigationMapper getNavigationMapper() {
		return navigationMapper;
	}

	public void setNavigationMapper(NavigationMapper navigationMapper) {
		this.navigationMapper = navigationMapper;
	}

}
