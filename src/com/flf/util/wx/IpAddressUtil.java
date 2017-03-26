package com.flf.util.wx;

/**
 * @content 
 * @author joie
 * @date 2015-12-9
 */
import javax.servlet.http.HttpServletRequest;

public class IpAddressUtil {

	/** 获取IP */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
//		出现这种状态:	192.168.1.2,192.68.45.52
		if(ip.contains(","))
		{
			String[] arr=ip.split(",");
			ip=arr[1].trim();
		}
		return ip;
	}

}