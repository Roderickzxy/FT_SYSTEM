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

import com.flf.entity.Fitment;
import com.flf.service.FitmentService;
/**
 * 
 * <br>
 * <b>功能：</b>FitmentController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/fitment")
public class FitmentController {
	
	private final static Logger log= Logger.getLogger(FitmentController.class);
	@Autowired(required=false) 
	private FitmentService fitmentService; 

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Fitment fitment){
		List<Fitment> fitmentList = fitmentService.queryByList(fitment);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fitment");
		mv.addObject("fitmentList", fitmentList);
		mv.addObject("fitment", fitment);
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param fitment
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveFitment(Fitment fitment){
		ModelAndView mv = new ModelAndView();
		if(fitment.getId()==null || fitment.getId().intValue()==0){
			fitmentService.add(fitment);
			mv.addObject("message","success");
		}else{
			fitmentService.update(fitment);
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
		return "fitment_info";
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Fitment fitment = fitmentService.queryById(id);
		mv.addObject("fitment", fitment);
		mv.setViewName("fitment_info");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		fitmentService.delete(id);
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
