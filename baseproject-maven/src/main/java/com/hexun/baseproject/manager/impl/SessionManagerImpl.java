package com.hexun.baseproject.manager.impl;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.baseproject.constants.Constants;
import com.hexun.baseproject.entity.User;
import com.hexun.baseproject.manager.SessionManager;
import com.hexun.baseproject.service.UserService;
/**
 * 管理session和cookie
 * @author zhoudong
 *
 */
@Service
public class SessionManagerImpl implements SessionManager {
	private static Logger logger = Logger.getLogger(SessionManagerImpl.class);
	@Resource
	private UserService userService;
	
	@Override
	public User getSessionAndCookie(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String userId = "";
		
		//先从session取数据
		if(request.getSession().getAttribute("user") != null){
			return user;
		}
		Cookie cookies[] = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constants.config.getString("COOKIE_DOMAIN"))) {
					userId = cookie.getValue();
					user = userService.findUserByUserId(userId);
					if(user != null){
						request.getSession().setAttribute("user", user);
					}
				}
			}
		} else {
			return null;
		}
		return user;
	}
	
	/**
	 * 检查cookie是否存在
	 */
	@Override
	public ModelAndView checkSession(HttpServletRequest request) {
		User user = getSessionAndCookie(request);
		if(user == null){
			logger.info("Cookie不存在,跳转登录..");
			return new ModelAndView("redirect:/user/login?returnUrl=" + request.getRequestURL());
		}else {
			return null;
		}
	}

}
