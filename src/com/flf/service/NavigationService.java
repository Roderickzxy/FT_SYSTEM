package com.flf.service;

import java.util.List;
import com.flf.entity.Navigation;

public interface NavigationService {
	Navigation getNavigationById(Integer id);
	List<Navigation> listAllNavigation();
	boolean insertNavigation(Navigation navigation);
	boolean updateNavigation(Navigation navigation);
	void deleteNavigationById(Integer id);
}
