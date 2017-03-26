package com.flf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flf.entity.MsgType;
import com.flf.service.MsgTypeService;


@Controller
@RequestMapping(value="/msgType")
public class MsgTypeController {
	
	@Autowired
	private MsgTypeService msgTypeService;

	/**
	 * 显示新闻类型列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Model model){
		List<MsgType> msgTypeList = msgTypeService.listAllParentMsgType();
		model.addAttribute("msgTypeList", msgTypeList);
		return "msgType";
	}
	
	/**
	 * 请求新增新闻类型页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		List<MsgType> msgTypeList = msgTypeService.listAllParentMsgType();
		model.addAttribute("msgTypeList", msgTypeList);
		return "msgType_info";
	}
	
	/**
	 * 请求编辑新闻类型页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String toEdit(@RequestParam Integer id,Model model){
		MsgType msgType = msgTypeService.getMsgTypeById(id);
		model.addAttribute("msgType", msgType);
		if(msgType.getParent()!=null && msgType.getParent().intValue()>0){
			List<MsgType> msgTypeList = msgTypeService.listAllParentMsgType();
			model.addAttribute("msgTypeList", msgTypeList);
		}
		return "msgType_info";
	}
	
	/**
	 * 保存新闻类型信息
	 * @param msgType
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/save")
	public String save(MsgType msgType,Model model){
		msgTypeService.saveMsgType(msgType);
		model.addAttribute("message", "success");
		return "save_result";
	}
	
	/**
	 * 获取新闻类型大类
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/parent")
	public void getParent(HttpServletResponse response){
		List<MsgType> parentList = msgTypeService.listAllParentMsgType();
		JSONArray arr = JSONArray.fromObject(parentList);
		PrintWriter out;
		try {
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			String json = arr.toString();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取当前新闻类型的所有子新闻类型
	 * @param id
	 * @param response
	 */
	@RequestMapping(value="/sub")
	public void getSub(@RequestParam Integer id,HttpServletResponse response){
		List<MsgType> subMsgType = msgTypeService.listSubMsgTypeByParentId(id);
		JSONArray arr = JSONArray.fromObject(subMsgType);
		PrintWriter out;
		try {
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			String json = arr.toString();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除菜新闻类型
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/del")
	public void delete(@RequestParam Integer id,PrintWriter out){
		msgTypeService.deleteMsgTypeById(id);
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
