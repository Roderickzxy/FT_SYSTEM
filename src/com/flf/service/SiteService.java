package com.flf.service;

import java.util.List;
import com.flf.entity.Site;

public interface SiteService {
	Site getSiteById(Integer id);
	List<Site> listAllSite();
	boolean insertSite(Site site);
	boolean updateSite(Site site);
	void deleteSiteById(Integer id);
}
