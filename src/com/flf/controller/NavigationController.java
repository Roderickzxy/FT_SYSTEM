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
import com.flf.entity.Navigation;
import com.flf.service.NavigationService;


@Controller
@RequestMapping(value="/navigation")
public class NavigationController {
	
	@Autowired
	private NavigationService navigationService;

	/**
	 * 显示航表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Model model){
		List<Navigation> navigationList = navigationService.listAllNavigation();
		model.addAttribute("navigationList", navigationList);
		return "navigation";
	}
	
	/**
	 * 保存信息
	 * @param out
	 * @param msg
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveNavigation(Navigation navigation){
		ModelAndView mv = new ModelAndView();
		if(navigation.getId()==null || navigation.getId().intValue()==0){
			if(navigationService.insertNavigation(navigation)==false){
				mv.addObject("message","failed");
			}else{
				mv.addObject("message","success");
			}
		}else{
			navigationService.updateNavigation(navigation);
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 请求新增 栏目导航页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		return "navigation_info";
	}
	/**
	 * 请求编辑栏目导航页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Navigation navigation = navigationService.getNavigationById(id);
		mv.addObject("navigation", navigation);
		mv.setViewName("navigation_info");
		return mv;
	}
	/**
	 * 删除信息
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		navigationService.deleteNavigationById(id);
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
