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
import com.flf.entity.Customerproperty;
import com.flf.entity.User;
import com.flf.service.CustomerService;
import com.flf.service.CustomerpropertyService;
import com.flf.service.UserService;
import com.flf.util.Const;
/**
 * 
 * <br>
 * <b>功能：</b>CustomerController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	private final static Logger log= Logger.getLogger(CustomerController.class);
	@Autowired(required=false) 
	private CustomerService customerService;
	
	@Autowired(required=false) 
	private UserService userService; 
	
	@Autowired(required=false) 
	private CustomerpropertyService customerpropertyService;

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Customer customer){
		List<Customer> customerList = customerService.queryByList(customer);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		mv.addObject("customerList", customerList);
		mv.addObject("customer", customer);
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
	public ModelAndView saveCustomer(Customer customer,HttpSession session){
		ModelAndView mv = new ModelAndView();
		User sessionuser = (User)session.getAttribute(Const.SESSION_USER);
		if(customer.getId()==null || customer.getId().intValue()==0){
			customer.setUser(sessionuser);
			customerService.add(customer);
			Long customerId = customer.getId();
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
			//添加业务参数，权限
			Customerproperty customerproperty1 = new Customerproperty();
			customerproperty1.setCustomer(customerService.queryById(customerId));
			customerproperty1.setType("业务参数");
			customerproperty1.setCode("cbjlx");
			customerproperty1.setFittype("成本价类型");
			customerproperty1.setName("摊薄持仓成本");
			customerpropertyService.add(customerproperty1);
			Customerproperty customerproperty2 = new Customerproperty();
			customerproperty2.setCustomer(customerService.queryById(customerId));
			customerproperty2.setType("业务参数");
			customerproperty2.setCode("fwghldcx");
			customerproperty2.setFittype("服务关怀类短彩信");
			customerproperty2.setName("接收");
			customerpropertyService.add(customerproperty2);
		    Customerproperty customerproperty3 = new Customerproperty();
		    customerproperty3.setCustomer(customerService.queryById(customerId));
			customerproperty3.setType("权限");
			customerproperty3.setCode("fxtsgp");
			customerproperty3.setFittype("风险提示股票");
			customerproperty3.setName("已开通");
			customerpropertyService.add(customerproperty3);
			Customerproperty customerproperty4 = new Customerproperty();
			customerproperty4.setCustomer(customerService.queryById(customerId));
			customerproperty4.setType("权限");
			customerproperty4.setCode("tsgp");
			customerproperty4.setFittype("退市股票");
			customerproperty4.setName("已开通");
			customerpropertyService.add(customerproperty4);
			
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
		Customer customer = customerService.queryById(id);
		User user = userService.getUserByAccountAndIDCardNum(customer.getAccount()+"-"+customer.getIdCardNum());
		userService.deleteUser(user.getUserId());
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
