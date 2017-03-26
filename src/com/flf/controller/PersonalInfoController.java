package com.flf.controller;


import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import com.flf.entity.User;
import com.flf.service.CustomerService;
import com.flf.service.UserService;
import com.flf.util.Const;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/personalinfo")
public class PersonalInfoController {
	
	private final static Logger log= Logger.getLogger(PersonalInfoController.class);
	@Autowired(required=false) 
	private CustomerService customerService;
	
	@Autowired(required=false) 
	private UserService userService; 

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Customer customer,HttpSession session){
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("personalinfo");
//		mv.addObject("customerList", customerList);
		mv.addObject("customer", customerList.get(0));
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param customer
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveCustomer(Customer customer){
		ModelAndView mv = new ModelAndView();
		if(customer.getId()==null || customer.getId().intValue()==0){
			customerService.add(customer);
			//用客户账号-身份证号区别在用户表区别用户
			User user = new User();
			user.setCustomerId(customer.getAccount()+"-"+customer.getIdCardNum());
			user.setLoginname(customer.getAccount());
			user.setPassword(customer.getPassword());
			user.setUsername(customer.getName());
			user.setStatus(0);
			user.setRoleId(3);
			user.setLastLoginEnd(new Date());
			user.setLastLogin(new Date());
			userService.insertUser(user);
			mv.addObject("message","success");
		}else{
			User user = userService.getUserByAccountAndIDCardNum(customer.getAccount()+"-"+customer.getIdCardNum());
			user.setCustomerId(customer.getAccount()+"-"+customer.getIdCardNum());
			user.setLoginname(customer.getAccount());
			user.setPassword(customer.getPassword());
			user.setUsername(customer.getName());
			user.setStatus(0);
			user.setRoleId(3);
			user.setLastLoginEnd(new Date());
			user.setLastLogin(new Date());
			userService.updateUser(user);
			customerService.update(customer);
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
		return "customer_info";
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Customer customer = customerService.queryById(id);
		mv.addObject("customer", customer);
		mv.setViewName("customer_info");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		customerService.delete(id);
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
