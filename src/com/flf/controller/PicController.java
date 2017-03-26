package com.flf.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.flf.entity.Pic;
import com.flf.entity.User;
import com.flf.service.PicService;
import com.flf.service.PicTypeService;
import com.flf.util.Const;


@Controller
@RequestMapping(value="/pic")
public class PicController {
	
	@Autowired
	private PicService picService;
	@Autowired
	private PicTypeService picTypeService;

	/**
	 * 显示信息列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Pic pic){
		List<Pic> picList = picService.listPicJoinPicType(pic);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pic");
		mv.addObject("picList", picList);
		mv.addObject("pic", pic);
		return mv;
	}
	/**
	 * 保存新闻
	 * @param out
	 * @param pic
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView savePic(Pic pic,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//获取当前用户
		User user = (User)session.getAttribute(Const.SESSION_USER);
		
		if(pic.getId()==null || pic.getId().intValue()==0){
			if(picService.insertPic(pic)==false){
				mv.addObject("message","failed");
			}else{
				mv.addObject("message","success");
			}
		}else{
			Pic tempPic = picService.getPicById(pic.getId());
			if(pic.getPic()==null || pic.getPic().equals("")){
				pic.setPic(tempPic.getPic());//图片
			}
			if(pic.getHouseResourceID()==null || pic.getHouseResourceID().equals("")){
				pic.setHouseResourceID(tempPic.getHouseResourceID());//房源ID
			}
			if(pic.getTitle()==null || pic.getTitle().equals("")){
				pic.setTitle(tempPic.getTitle());//标题
			}
			if(pic.getDescripse()==null || pic.getDescripse().equals("")){
				pic.setDescripse(tempPic.getDescripse());//作品描述
			}
			if(pic.getStatus()==null || pic.getStatus().equals("")){
				pic.setStatus(tempPic.getStatus());//状态
			}
			if(pic.getMsgId()==null || pic.getMsgId().equals("")){
				pic.setMsgId(tempPic.getMsgId());//新闻ID
			}
			if(pic.getPicTypeId()==null || pic.getPicTypeId().equals("")){
				pic.setPicTypeId(tempPic.getPicTypeId());//作品类型
			}
			if(pic.getPriority()==null){
				pic.setPriority(tempPic.getPriority());//优先级
			}
			if(pic.getFigure()==null){
				pic.setFigure(tempPic.getFigure());//形像图
			}
			picService.updatePic(pic);
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 请求新增新闻页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		return "pic_info";
	}
	
	/**
	 * 请求编辑新闻页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Pic pic = picService.getPicById(id);
		//替换内容中的示签
		String descripse = pic.getDescripse();
		descripse.replaceAll("&", "&amp;");
		descripse.replaceAll("<", "&lt;");
		descripse.replaceAll(">", "&gt;");
		pic.setDescripse(descripse);
		
		mv.addObject("pic", pic);
		mv.setViewName("pic_info");
		return mv;
	}
	
	/**
	 * 删除信息
	 * @param msgId
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		picService.deletePicById(id);
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
