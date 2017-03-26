package com.flf.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
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

import com.flf.entity.Assinfo;
import com.flf.service.AssinfoService;
/**
 * 
 * <br>
 * <b>功能：</b>AssinfoController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/assinfo")
public class AssinfoController {
	
	private final static Logger log= Logger.getLogger(AssinfoController.class);
	@Autowired(required=false) 
	private AssinfoService assinfoService; 

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Assinfo assinfo){
		List<Assinfo> assinfoList = assinfoService.queryByList(assinfo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("assinfo");
		mv.addObject("assinfoList", assinfoList);
		mv.addObject("assinfo", assinfo);
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param assinfo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveAssinfo(Assinfo assinfo){
		ModelAndView mv = new ModelAndView();
		if(assinfo.getId()==null || assinfo.getId().intValue()==0){
			assinfoService.add(assinfo);
			mv.addObject("message","success");
		}else{
			assinfoService.update(assinfo);
		}
		mv.setViewName("save_result");
		return mv;
	}
	/**
	 * 请求新增页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		return "assinfo_info";
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Assinfo assinfo = assinfoService.queryById(id);
		mv.addObject("assinfo", assinfo);
		mv.setViewName("assinfo_info");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		assinfoService.delete(id);
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
