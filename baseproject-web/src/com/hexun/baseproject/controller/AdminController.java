package com.hexun.baseproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.framework.core.controller.DefaultBaseController;
import com.hexun.framework.core.properties.PropertiesUtils;
/**
 * 首页
 * @author zhoudong
 *
 */
@Controller
public class AdminController extends DefaultBaseController{
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * 首页
	 * 访问路径：localhost:8080/baseproject-web
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index() {
		return new ModelAndView("index","url",PropertiesUtils.getString("BASE_URL"));
	}
	
}
