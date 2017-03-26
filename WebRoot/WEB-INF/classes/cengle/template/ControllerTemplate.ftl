package ${bussPackage}.controller;


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

import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end.${className};
import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;
/**
 * 
 * <br>
 * <b>功能：</b>${className}Controller<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/${lowerName}")
public class ${className}Controller {
	
	private final static Logger log= Logger.getLogger(${className}Controller.class);
	@Autowired(required=false) 
	private ${className}Service ${lowerName}Service; 

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(${className} ${lowerName}){
		List<${className}> ${lowerName}List = ${lowerName}Service.queryByList(${lowerName});
		ModelAndView mv = new ModelAndView();
		mv.setViewName("${lowerName}");
		mv.addObject("${lowerName}List", ${lowerName}List);
		mv.addObject("${lowerName}", ${lowerName});
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param ${lowerName}
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save${className}(${className} ${lowerName}){
		ModelAndView mv = new ModelAndView();
		if(${lowerName}.getId()==null || ${lowerName}.getId().intValue()==0){
			${lowerName}Service.add(${lowerName});
			mv.addObject("message","success");
		}else{
			${lowerName}Service.update(${lowerName});
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
		return "${lowerName}_info";
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		${className} ${lowerName} = ${lowerName}Service.queryById(id);
		mv.addObject("${lowerName}", ${lowerName});
		mv.setViewName("${lowerName}_info");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		${lowerName}Service.delete(id);
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
