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
import com.flf.entity.PicType;
import com.flf.service.PicTypeService;


@Controller
@RequestMapping(value="/picType")
public class PicTypeController {
	
	@Autowired
	private PicTypeService picTypeService;

	/**
	 * 显示作品类型列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Model model){
		List<PicType> picTypeList = picTypeService.listAllParentPicType();
		model.addAttribute("picTypeList", picTypeList);
		return "picType";
	}
	
	/**
	 * 请求新增作品类型页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		List<PicType> picTypeList = picTypeService.listAllParentPicType();
		model.addAttribute("picTypeList", picTypeList);
		return "picType_info";
	}
	
	/**
	 * 请求编辑作品类型页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String toEdit(@RequestParam Integer id,Model model){
		PicType picType = picTypeService.getPicTypeById(id);
		model.addAttribute("picType", picType);
		if(picType.getParent()!=null && picType.getParent().intValue()>0){
			List<PicType> picTypeList = picTypeService.listAllParentPicType();
			model.addAttribute("picTypeList", picTypeList);
		}
		return "picType_info";
	}
	
	/**
	 * 保存作品类型信息
	 * @param picType
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/save")
	public String save(PicType picType,Model model){
		picTypeService.savePicType(picType);
		model.addAttribute("message", "success");
		return "save_result";
	}
	
	/**
	 * 获取当前作品类型大类
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/parent")
	public void getParent(HttpServletResponse response){
		List<PicType> parentList = picTypeService.listAllParentPicType();
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
	 * 获取当前作品类型的所有子作品类型
	 * @param id
	 * @param response
	 */
	@RequestMapping(value="/sub")
	public void getSub(@RequestParam Integer id,HttpServletResponse response){
		List<PicType> subPicType = picTypeService.listSubPicTypeByParentId(id);
		JSONArray arr = JSONArray.fromObject(subPicType);
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
	 * 删除菜作品类型
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/del")
	public void delete(@RequestParam Integer id,PrintWriter out){
		picTypeService.deletePicTypeById(id);
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
