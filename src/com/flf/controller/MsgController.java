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

import com.flf.entity.Msg;
import com.flf.entity.User;
import com.flf.service.MsgService;
import com.flf.service.MsgTypeService;
import com.flf.util.Const;


@Controller
@RequestMapping(value="/msg")
public class MsgController {
	
	@Autowired
	private MsgService msgService;
	@Autowired
	private MsgTypeService msgTypeService;

	/**
	 * 显示信息列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Msg msg){
		List<Msg> msgList = msgService.listMsgJoinMsgType(msg);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg");
		mv.addObject("msgList", msgList);
		mv.addObject("msg", msg);
		return mv;
	}
	/**
	 * 保存新闻
	 * @param out
	 * @param msg
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveMsg(Msg msg,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//获取当前用户
		User user = (User)session.getAttribute(Const.SESSION_USER);
		
		if(msg.getMsgId()==null || msg.getMsgId().intValue()==0){
			msg.setLoginname(user.getLoginname());//创建者
			if(msgService.insertMsg(msg)==false){
				mv.addObject("message","failed");
			}else{
				mv.addObject("message","success");
			}
		}else{
			Msg tempMsg = msgService.getMsgById(msg.getMsgId());
			if(msg.getPic()==null || msg.getPic().equals("")){
				msg.setPic(tempMsg.getPic());//形像图
			}
			if(msg.getTitle()==null || msg.getTitle().equals("")){
				msg.setTitle(tempMsg.getTitle());//新闻标题
			}
			if(msg.getContent()==null || msg.getContent().equals("")){
				msg.setContent(tempMsg.getContent());//新闻内容
			}
			if(msg.getStatus()==null || msg.getStatus().equals("")){
				msg.setStatus(tempMsg.getStatus());//状态
			}
			if(msg.getMsgTypeId()==null || msg.getMsgTypeId().equals("")){
				msg.setMsgTypeId(tempMsg.getMsgTypeId());//新闻类型
			}
			msg.setLoginname(tempMsg.getLoginname());//创建者
			if(msg.getSytj()==null){
				msg.setSytj(tempMsg.getSytj());//首页推荐
			}
			if(msg.getDescripse()==null || msg.getDescripse().equals("")){
				msg.setDescripse(tempMsg.getDescripse());//新闻描述
			}
			msgService.updateMsg(msg);
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
		return "msg_info";
	}
	
	/**
	 * 请求编辑新闻页面
	 * @param msgTypeId
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam Integer msgId){
		ModelAndView mv = new ModelAndView();
		Msg msg = msgService.getMsgById(msgId);
		
		//替换内容中的示签
		String content = msg.getContent();
		content.replaceAll("&", "&amp;");
		content.replaceAll("<", "&lt;");
		content.replaceAll(">", "&gt;");
		msg.setContent(content);
		
		mv.addObject("msg", msg);
		mv.setViewName("msg_info");
		return mv;
	}
	
	/**
	 * 删除信息
	 * @param msgId
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam Integer msgId,PrintWriter out){
		msgService.deleteMsgById(msgId);
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
