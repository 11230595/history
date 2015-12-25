package com.hexun.framework.core.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hexun.framework.core.properties.PropertiesUtils;

/**
 * 基础controller
 * 
 * @author zhoudong
 *
 */
public class DefaultBaseController implements ServletConfigAware {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// -- header 常量定义 --//
	private static final String HEADER_ENCODING = "encoding";
	private static final String HEADER_NOCACHE = "no-cache";
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final boolean DEFAULT_NOCACHE = true;

	protected static final int PAGE_SIZE = 10; // 每页的记录数
	protected static final int PAGE_NO = 1; // 当前页号

	//结果集返回Map
	protected Map<String,Object> resultMap = new LinkedHashMap<String, Object>();
	
	/**
	 * 获取应用绝对路径
	 * 
	 * @return
	 */
	protected String getWebApplicationAbsolutePath(HttpServletRequest request) {
		String realPath = getRequest().getSession().getServletContext().getRealPath("/");
		return realPath;
	}

	/**
	 * 取得HttpServletRequest的简化函数.
	 */
	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * 取得session
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 取得HttpServletResponse的简化函数.
	 */
	protected HttpServletResponse getResponse() {
		return ((ServletWebRequest) RequestContextHolder.getRequestAttributes())
				.getResponse();
	}
	/**
	 * 获取modelandview对象
	 * @return
	 */
	protected ModelAndView getModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("baseUrl", PropertiesUtils.getString("BASE_URL"));
		mav.addObject("realPath", getWebApplicationAbsolutePath(getRequest()));
		return mav;
	}
	
	/**
	 * 重定向
	 * @param redirectUrl
	 * @return
	 */
	protected ModelAndView redirect(String redirectUrl){
		return new ModelAndView(new RedirectView(redirectUrl));
	}
	
	public void setServletConfig(ServletConfig servletConfig) {

	}
}
