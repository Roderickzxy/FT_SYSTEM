package com.flf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flf.entity.User;
import com.flf.util.Const;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// TODO Auto-generated method stub
		String path = request.getServletPath();
		// 匹配/upload/html/下的静态资源。
		if (path.matches(Const.NO_INTERCEPTOR_PATH2)) {
			return true;
		}
		// 匹配/web/index/下的静态资源
		if (path.matches(Const.NO_INTERCEPTOR_PATH5)) {
			return true;
		}
		if (path.matches(Const.NO_INTERCEPTOR_PATH51)) {
			return true;
		}
		if (path.matches(Const.NO_INTERCEPTOR_PATH52)) {
			return true;
		}
		HttpSession session = request.getSession();
		Object user = null;
		// // 匹配访问/web/zk下的资源,进行限制操作,设置跳转租客页面
		if (path.matches(Const.NO_INTERCEPTOR_PATH9)) {
			if (session.getAttribute(Const.SESSION_HIRER) != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/web/index/zk_login.jsp");
				return false;
			}

		}

		// 匹配访问/web/fd下的资源,进行限制操作,设置跳转房东页面
		if (path.matches(Const.NO_INTERCEPTOR_PATH10)) {
			if (session.getAttribute(Const.SESSION_OWNER) != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/web/index/fd_login.jsp");
				return false;
			}

		}

		// 匹配后台登录地址
		if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
			return true;
		} else {
			if (session.getAttribute(Const.SESSION_USER) != null) {
				user = (User) session.getAttribute(Const.SESSION_USER);
				if (user != null) {
					return true;
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/login.html");
					return false;
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login.html");
				return false;
			}
		}
	}

}
