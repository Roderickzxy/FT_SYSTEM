package com.flf.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

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
import com.flf.service.UserService;
import com.flf.util.Const;
/**
 * 
 * <br>
 * <b>功能：</b>AccountinfoController<br>
 *   <br>
 */ 
@Controller
@RequestMapping(value="/accountinfo")
public class AccountinfoController {
	
	private final static Logger log= Logger.getLogger(AccountinfoController.class);
	@Autowired(required=false) 
	private AccountinfoService accountinfoService; 
	
	@Autowired(required=false) 
	private TransactionflowService transactionflowService; 
	
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
	public ModelAndView list(Accountinfo accountinfo,String name){
		if(name!=null && !"".equalsIgnoreCase(name)){
		Customer conditionCustomer = new Customer();
		conditionCustomer.setName(name);
		accountinfo.setCustomer(conditionCustomer);
		}
		Transactionflow transactionflow = new Transactionflow();
		List<Transactionflow> transactionflowList = transactionflowService.queryByList(transactionflow);
		List<Accountinfo> accountInfoList = accountinfoService.queryByList(accountinfo);
		for(Transactionflow transactionflowtemp: transactionflowList){//交易流水
			String tracustomerid = transactionflowtemp.getCustomerId();
			String trastype = transactionflowtemp.getOperate();
			for(int i = 0;i<accountInfoList.size();i++){
				 Accountinfo orginaccountinfo = accountInfoList.get(i);
				String accountcustomerid = orginaccountinfo.getCustomer().getId().toString();
				if(tracustomerid.equalsIgnoreCase(accountcustomerid)){
					 if("证券转银行".equalsIgnoreCase(trastype)){//转出
						 BigDecimal orgout =  orginaccountinfo.getTraout()==null?new BigDecimal(0):orginaccountinfo.getTraout();
						 orginaccountinfo.setTraout(orgout.add(transactionflowtemp.getAmount()));
						 accountInfoList.set(i,orginaccountinfo);
					 }else if("银行转证券".equalsIgnoreCase(trastype)){//转入
						 BigDecimal orgin =  orginaccountinfo.getTrain()==null?new BigDecimal(0):orginaccountinfo.getTrain();
						 orginaccountinfo.setTrain(orgin.add(transactionflowtemp.getAmount()));
						 accountInfoList.set(i,orginaccountinfo);
					 }
				}
			}
		}
		
		for(int j = 0;j<accountInfoList.size();j++){
			Accountinfo orginaccountinfo = accountInfoList.get(j);
			BigDecimal orgin =  orginaccountinfo.getTrain()==null?new BigDecimal(0):orginaccountinfo.getTrain();
			BigDecimal orgout =  orginaccountinfo.getTrain()==null?new BigDecimal(0):orginaccountinfo.getTraout();
				 orginaccountinfo.setTraowner(orgin.subtract(orgout));//资产
			 accountInfoList.set(j,orginaccountinfo);	
		}
//		List<Accountinfo> accountinfoList = accountinfoService.queryByList(accountinfo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("accountinfo");
		mv.addObject("accountinfoList", accountInfoList);
		mv.addObject("accountinfo", accountinfo);
		return mv;
	}
	/**
	 * 保存
	 * @param out
	 * @param accountinfo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveAccountinfo(Accountinfo accountinfo,String customerid,String userid,HttpSession session){
		ModelAndView mv = new ModelAndView();
		User accountinfouser ;
		Customer accountinfocustomer =null ;
		if(userid!=null && !"".equalsIgnoreCase(userid)){
			accountinfouser = userService.getUserById(Integer.parseInt(userid));
		}else{
		    accountinfouser = (User)session.getAttribute(Const.SESSION_USER);
		}
		if(customerid!=null && !"".equalsIgnoreCase(customerid)){
			accountinfocustomer = customerService.queryById(customerid);
		}
		accountinfo.setUser(accountinfouser);
		accountinfo.setCustomer(accountinfocustomer);
		accountinfo.setOperatedate(new Date());
		if(accountinfo.getId()==null || accountinfo.getId().intValue()==0){
			accountinfoService.add(accountinfo);
			mv.addObject("message","success");
		}else{
			accountinfoService.update(accountinfo);
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
		return "accountinfo_info";
	}
	/**
	 * 请求编辑页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer id){
		ModelAndView mv = new ModelAndView();
		Accountinfo accountinfo = accountinfoService.queryById(id);
		mv.addObject("accountinfo", accountinfo);
		mv.setViewName("accountinfo_info");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer id,PrintWriter out){
		accountinfoService.delete(id);
		out.write("success");
		out.flush();
		out.close();
	}
	
	/**
	 * 获取租客信息，JSON返回
	 * 
	 * @param binder
	 * @throws IOException
	 * 
	 */
	@RequestMapping(value = "/getCustomerJSON", method = RequestMethod.POST)
	public void getCustomerJSON(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Customer queryCustomer = new Customer();
		// 在这里添加筛选条件
		List<Customer> customerList = customerService
				.queryByList(queryCustomer);
		JSONArray json = JSONArray.fromObject(customerList);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json.toString());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
