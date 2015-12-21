package com.hexun.baseproject.view;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.baseproject.constants.Constants;
/**
 * 首页
 * @author zhoudong
 *
 */
@Controller
public class AdminController {
	private static Logger logger = Logger.getLogger(AdminController.class);
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("index","url",Constants.config.getString("BASE_URL"));
	}
	
}
