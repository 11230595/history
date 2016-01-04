package com.hexun.personalcms.controller;

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
public class PhotoController extends DefaultBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 首页
	 * 访问路径：localhost:8080/baseproject-web
	 * @return
	 */
	@RequestMapping(value="photo",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index() {
		return getModelAndView("photo");
	}
	
}
