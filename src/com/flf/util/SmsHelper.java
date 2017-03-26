package com.flf.util;

/*****************************************************
 * 功能描述：发送短信接口
 * @author  ml
 * @version 1.0 2016-01-12
 *****************************************************/
public class SmsHelper { 
	
	/**
	 * 
	 * @param mobile 手机号码，多个号码使用","分割
	 * @param msg 短信内容
	 * @return 返回值定义参见HTTP协议文档
	 * @throws Exception
	 */
	public static String sendSMS(String mobile,String msg) {			
		String sResult="-300";
		String url = Const.SMS_URL;// 应用地址
		String account = Const.SMS_UID;// 账号
		String pswd = Const.SMS_PSW;// 密码
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String product = null;// 产品ID
		String extno = null;// 扩展码

		try {
			sResult = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			System.out.println(sResult);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
		return sResult;
	}
	
	public static void main(String args[]) { 
		
		String result = SmsHelper.sendSMS("15813398327", "首页楼市短讯数据同步已完成,有多少记录待编辑,请编辑!谢谢!");
		System.out.print("提交任务返回结果：");
		System.out.println(result);	
	}
}
