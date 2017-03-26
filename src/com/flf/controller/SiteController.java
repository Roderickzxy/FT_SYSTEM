package com.flf.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flf.entity.Site;
import com.flf.service.SiteService;


@Controller
@RequestMapping(value="/site")
public class SiteController {
	
	@Autowired
	private SiteService siteService;

	/**
	 * 显示航表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Model model){
		List<Site> siteList = siteService.listAllSite();
		model.addAttribute("siteList", siteList);
		return "site";
	}
	
	/**
	 * 保存信息
	 * @param out
	 * @param site
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveSite(Site site){
		ModelAndView mv = new ModelAndView();
		if(site.getId()==null || site.getId().intValue()==0){
			if(siteService.insertSite(site)==false){
				mv.addObject("message","failed");
			}else{
				mv.addObject("message","success");
			}
		}else{
			siteService.updateSite(site);
		}
		mv.setViewName("save_result");
		return mv;
	}
	/**
	 * 请求新增新闻类型页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		return "site_info";
	}
	/**
	 * 请求编辑新闻类型页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Site site = siteService.getSiteById(id);
		mv.addObject("site", site);
		mv.setViewName("site_info");
		return mv;
	}
	/**
	 * 删除信息
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		siteService.deleteSiteById(id);
		out.write("success");
		out.flush();
		out.close();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
