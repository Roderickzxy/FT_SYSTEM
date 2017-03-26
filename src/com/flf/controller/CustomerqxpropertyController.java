package com.flf.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.flf.entity.Customer;
import com.flf.entity.Customerproperty;
import com.flf.entity.User;
import com.flf.service.CustomerService;
import com.flf.service.CustomerpropertyService;
import com.flf.util.Const;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerpropertyController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/customerqxproperty")
public class CustomerqxpropertyController {
	
	private final static Logger log= Logger.getLogger(CustomerqxpropertyController.class);
	@Autowired(required=false) 
	private CustomerpropertyService customerpropertyService; 

	@Autowired(required=false) 
	private CustomerService customerService;
	
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Customerproperty customerproperty,HttpSession session){
		Customer customer = new Customer();
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		customerproperty.setCustomer(customerList.get(0));
		customerproperty.setType("权限");
		List<Customerproperty> customerpropertyList = customerpropertyService.queryByList(customerproperty);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerqxproperty");
		mv.addObject("customerpropertyList", customerpropertyList);
		mv.addObject("customerproperty", customerproperty);
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param customerproperty
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveCustomerproperty(Customerproperty customerproperty,HttpSession session){
		Customer customer = new Customer();
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		customerproperty.setCustomer(customerList.get(0));
		customerproperty.setType("权限");
		ModelAndView mv = new ModelAndView();
		if(customerproperty.getId()==null || customerproperty.getId().intValue()==0){
			customerpropertyService.add(customerproperty);
			mv.addObject("message","success");
		}else{
			customerpropertyService.update(customerproperty);
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
		return "customerproperty_info";
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public void toEdit(@RequestParam Integer id,String name,PrintWriter out){
		Customerproperty customerproperty = customerpropertyService.queryById(id);
		customerproperty.setName(name);
		customerpropertyService.update(customerproperty);
		out.write("success");
		out.flush();
		out.close();
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		customerpropertyService.delete(id);
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
