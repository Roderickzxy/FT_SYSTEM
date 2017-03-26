package com.flf.service.impl;

import java.util.List;
import com.flf.entity.Site;
import com.flf.mapper.SiteMapper;
import com.flf.service.SiteService;


public class SiteServiceImpl implements SiteService{
	
	private SiteMapper siteMapper;
	
	//删除一条记录
	public void deleteSiteById(Integer id) {
		siteMapper.deleteSiteById(id);
	}
	
	//获取单条记录
	public Site getSiteById(Integer id) {
		return siteMapper.getSiteById(id);
	}
	
	//修改记录
	public boolean updateSite(Site site) {
		if(siteMapper.getCountSiteByDomain(site)>0)
			return false;
		else{
			siteMapper.updateSite(site);
			return true;
		}
	}
	
	//插入一条记录
	public boolean insertSite(Site site) {
		if(siteMapper.getCountSiteByDomain(site)>0)
			return false;
		else{
			siteMapper.insertSite(site);
			return true;
		}
	}
	
	//获取所有有记录
	public List<Site> listAllSite() {
		return siteMapper.listAllSite();
	}

	public SiteMapper getSiteMapper() {
		return siteMapper;
	}

	public void setSiteMapper(SiteMapper siteMapper) {
		this.siteMapper = siteMapper;
	}
}
