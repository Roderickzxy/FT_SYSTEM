package com.flf.mapper;

import java.util.List;
import com.flf.entity.Navigation;

public interface NavigationMapper {
	Navigation getNavigationById(Integer id);
	List<Navigation> listAllNavigation();
	void insertNavigation(Navigation navigation);
	void updateNavigation(Navigation navigation);
	void deleteNavigationById(Integer id);
	int getCountNavigationByName(Navigation navigation);
}
