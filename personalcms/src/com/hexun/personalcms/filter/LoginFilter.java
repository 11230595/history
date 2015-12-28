package com.hexun.personalcms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hexun.framework.core.properties.PropertiesUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if(!req.getRequestURL().toString().endsWith("pub.do")){
			logger.info("访问URL{},不是pub.do,放行！",req.getRequestURL().toString());
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = req.getSession();
		if(session.getAttribute("ts_user") == null){
			logger.info("用户未登录");
			resp.sendRedirect(PropertiesUtils.getString("BASE_URL") + "/user/login.do");
		}else {
			logger.info("用户已登录，登录名：{}" , JSONObject.fromObject(session.getAttribute("ts_user")).toString());
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
