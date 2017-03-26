package com.flf.controller;


import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
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

import com.flf.entity.Accountinfo;
import com.flf.entity.Customer;
import com.flf.entity.Transactionflow;
import com.flf.entity.User;
import com.flf.service.AccountinfoService;
import com.flf.service.CustomerService;
import com.flf.service.TransactionflowService;
import com.flf.util.Const;
import com.flf.util.ExportClientExcel;
/**
 * 
 * <br>
 * <b>功能：</b>TransactionflowController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/transactionflow")
public class TransactionflowController {
	
	private final static Logger log= Logger.getLogger(TransactionflowController.class);
	@Autowired(required=false) 
	private TransactionflowService transactionflowService; 

	@Autowired(required=false) 
	private CustomerService customerService;
	
	@Autowired(required=false) 
	private AccountinfoService accountinfoService;
	
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Transactionflow transactionflow,String startTradate,String endTradate,HttpSession session){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		Customer customer = new Customer();
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		transactionflow.setCustomerId(customerList.get(0).getId().toString());
		try {
		if(endTradate!=null && !"".equalsIgnoreCase(endTradate)){
				transactionflow.setEndTradate(sdf.parse(endTradate));
			}
			if(startTradate!=null && !"".equalsIgnoreCase(startTradate)){
			transactionflow.setStartTradate(sdf.parse(startTradate));
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Transactionflow> transactionflowList = transactionflowService.queryByList(transactionflow);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("transactionflow");
		mv.addObject("transactionflowList", transactionflowList);
		mv.addObject("transactionflow", transactionflow);
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param transactionflow
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveTransactionflow(Transactionflow transactionflow,HttpSession session){
		ModelAndView mv = new ModelAndView();
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		Customer customer = new Customer();
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		if(transactionflow.getId()==null || transactionflow.getId().intValue()==0){
			transactionflow.setCustomerId(customerList.get(0).getId().toString());
			transactionflow.setTradate(new Date());
			transactionflow.setTratime(new Timestamp(new Date().getTime()));
			transactionflow.setStatus("成功");
			transactionflowService.add(transactionflow);
			mv.addObject("message","success");
		}else{
			transactionflowService.update(transactionflow);
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
	public ModelAndView toAdd(Model model,HttpSession session){
		ModelAndView mv = new ModelAndView();
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		Customer customer = new Customer();
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		Accountinfo accountinfo = new Accountinfo();
		accountinfo.setCustomer(customerList.get(0));
		List<Accountinfo> accountinfoList = accountinfoService.queryByList(accountinfo);
		mv.addObject("accountinfo", accountinfoList.get(0));
		mv.setViewName("transactionflow_info");
		return mv;
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Transactionflow transactionflow = transactionflowService.queryById(id);
		mv.addObject("transactionflow", transactionflow);
		mv.setViewName("transactionflow_info");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		transactionflowService.delete(id);
		out.write("success");
		out.flush();
		out.close();
	}
	
	/**
	 * 导出
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/export")
	public void export(@RequestParam Integer id,PrintWriter out,HttpSession session){
		Transactionflow transactionflow = new Transactionflow();
		User user = (User)session.getAttribute(Const.SESSION_USER);
//		User usernew = userService.getUserById(user.getUserId());
		String accountAndIdCardNum = user.getCustomerId();
		String[] accountAndIdCardNumArray = accountAndIdCardNum.split("-");
		Customer customer = new Customer();
		customer.setAccount(accountAndIdCardNumArray[0]);
		customer.setIdCardNum(accountAndIdCardNumArray[1]);
		List<Customer> customerList = customerService.queryByList(customer);
		transactionflow.setCustomerId(customerList.get(0).getId().toString());
	
		List<Transactionflow> transactionflowList = transactionflowService.queryByList(transactionflow);
		ExportClientExcel.createExcel(transactionflowList,customerList.get(0));
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
