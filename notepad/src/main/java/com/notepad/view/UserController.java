package com.notepad.view;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.core.page.Page;
import com.framework.core.utils.IPUtils;
import com.notepad.constants.Constants;
import com.notepad.entity.LoginLog;
import com.notepad.entity.User;
import com.notepad.service.LoginLogService;
import com.notepad.service.UserService;

/**
 * 操作用户
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	@Resource
	private LoginLogService loginLogService;
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="/zc",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView zc() {
		return new ModelAndView("zhuce");
	}
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView("login","returnUrl",request.getParameter("returnUrl"));
	}
	
	/**
	 * 用户名是否可以使用
	 * @return
	 */
	@RequestMapping(value="/isCode",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> isCode(@RequestParam String userCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = userService.findUserByUserCode(userCode);
		if(user == null){
			map.put("respMsg", true);
		}else {
			map.put("respMsg", false);
		}
		return map;
	}
	/**
	 * 邮箱是否可以使用
	 * @return
	 */
	@RequestMapping(value="/isEmail",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> isEmail(@RequestParam String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = userService.findUserByEmail(email);
		if(user == null){
			map.put("respMsg", true);
		}else {
			map.put("respMsg", false);
		}
		return map;
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value="/saveUser",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveUser(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		user.setDelFlag(0);
		user.setEmail(request.getParameter("email"));
		user.setUserCode(request.getParameter("userCode"));
		user.setPassword(request.getParameter("password"));
		
		try {
			userService.insert(user);
			map.put("respCode", 0);
			map.put("baseUrl", Constants.config.getString("BASE_URL"));
		} catch (Exception e) {
			logger.info(e);
			map.put("respCode", 1);
		}
		
		return map;
	}
	
	/**
	 * 登陆
	 * @return
	 */
	@RequestMapping(value="/signin",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> signin(HttpServletRequest request,
			@RequestParam String userCode, @RequestParam String password,@RequestParam(required=false) String returnUrl) {
		Map<String, Object> map = new HashMap<String, Object>();
		String ip = IPUtils.getIP(request);
		
		User user = userService.login(userCode,password);
		
		if(user != null){
			map.put("respCode", 0); //登陆成功
			
			if(StringUtils.isNotBlank(returnUrl))
				map.put("returnUrl", returnUrl);
			else
				map.put("returnUrl", Constants.config.getString("BASE_URL"));
			
			request.getSession().setAttribute("user", user);
			
			//日志
			loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 0, userCode, "", ip, IPUtils.getAddress(ip)));
		}else {
			map.put("respCode", 1);	//登陆失败
			
			//日志
			loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 0, userCode, "该用户不存在！", ip, IPUtils.getAddress(ip)));
		}
		
		return map;
	}
	
	
	/**
	 * 其他登陆
	 * @return
	 */
	@RequestMapping(value="/otherSignin",method={RequestMethod.GET,RequestMethod.POST})
	public String otherSignin(HttpServletRequest request,
			@RequestParam String userCode,@RequestParam String openId,@RequestParam String accessToken) {
		
		User user = userService.findUserByUserId(openId);
		
		if(user == null){  //如果首次使用第三方登录本站，关联数据
			
			try {
				userCode = URLDecoder.decode(userCode, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			user = new User();
			user.setUserCode(userCode);
			user.setUserId(openId);
			user.setUsername(userCode);
			user.setEmail(accessToken);
			user.setCreateTime(new Date());
			user.setDelFlag(0);
			userService.insert(user);
		}
		request.getSession().setAttribute("user", user);
		
		//日志
		String ip = IPUtils.getIP(request);
		loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 1, userCode, "", ip, IPUtils.getAddress(ip)));
		
		return "redirect:/";
	}
	
	/**
	 * 用户中心
	 * @return
	 */
	@RequestMapping(value="/home/{userId}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userHome(@PathVariable String userId) {
		ModelAndView mav = new ModelAndView("userHome"); 
		return mav; 
	}
	
	/**
	 * 更新用户资料
	 * @return
	 */
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> userHome(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setPassword(request.getParameter("password"));
		
		try {
			userService.updateByPrimaryKeySelective(user);
			map.put("respCode", 0);
		} catch (Exception e) {
			logger.info(e);
			map.put("respCode", 1);
		}
		
		return map; 
	}
	
	/**
	 * 退出登陆
	 * @return
	 */
	@RequestMapping(value="/loginOut",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> loginOut(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		request.getSession().invalidate();
		map.put("respCode", 0);
		map.put("baseUrl", Constants.config.getString("BASE_URL"));
		
		return map; 
	}
	
	/**
	 * 分页获取用户，测试
	 * @return
	 */
	@RequestMapping(value="/findUserByPage",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findUserByPage(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int pageNo = 1;
		int pageSize = 10;
		Page<User> page = userService.findUserByPage("findUserByPage",param,pageNo,pageSize);
		map.put("page", page);
		return map; 
	}
}
