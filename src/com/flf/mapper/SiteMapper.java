package com.flf.mapper;

import java.util.List;
import com.flf.entity.Site;

public interface SiteMapper {
	Site getSiteById(Integer id);
	List<Site> listAllSite();
	void insertSite(Site site);
	void updateSite(Site site);
	void deleteSiteById(Integer id);
	int getCountSiteByDomain(Site site);
}
