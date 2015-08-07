package com.notepad.view;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/otherSignin",method={RequestMethod.GET,RequestMethod.POST})
	public String otherSignin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String userCode,@RequestParam String openId,@RequestParam String accessToken) throws UnsupportedEncodingException {
		
		User user = userService.findUserByUserId(openId);
		String ip = IPUtils.getIP(request);
		
		if(user == null){  //如果首次使用第三方登录本站，关联数据
			
			userCode = URLDecoder.decode(userCode, "utf-8");
			
			user = userService.findUserByUserCode(userCode); //userCode是否存在
			
			if(user == null){
				user = new User();
				user.setUserCode(userCode);
				user.setUserId(openId);
				user.setUsername(userCode);
				user.setEmail(accessToken);
				user.setCreateTime(new Date());
				user.setDelFlag(0);
				userService.insert(user);
			}else{
				loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 1, user.getUserCode(), userCode + "，已经有人使用，跳转到信息补充页面。", ip, IPUtils.getAddress(ip)));
				return "redirect:/user/userInfoFill/" + URLEncoder.encode(userCode, "utf-8") + "/" + openId + "/" + accessToken;
			}
		}
		request.getSession().setAttribute("user", user); //session
		addCookie(response,user.getUserId()); //cookie
		
		//日志
		loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 1, user.getUserCode(), "", ip, IPUtils.getAddress(ip)));
		
		return "redirect:/";
	}
	/**
	 * 设置cookie
	 * @param response
	 * @param userId
	 */
	private void addCookie(HttpServletResponse response,String userId){
		Cookie cookie = new Cookie("dovip_user", userId);       //(key,value)  
	    cookie.setPath("/");// 这个要设置  
	    cookie.setDomain(".dovip.top");//这样设置，能实现两个网站共用  
	    cookie.setMaxAge(365 * 24 * 60 * 60);// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位  
	    response.addCookie(cookie);         //添加第一个Cookie  
	}
	
	/**
	 * 用户名冲突跳转到重新填写用户名界面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/userInfoFill/{userCode}/{openId}/{accessToken}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userInfoFill(@PathVariable String userCode,@PathVariable String openId,@PathVariable String accessToken) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("userInfoFill"); 
		mav.addObject("userCode",URLDecoder.decode(userCode, "utf-8"));
		mav.addObject("openId",openId);
		mav.addObject("accessToken",accessToken);
		return mav; 
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
	public @ResponseBody Map<String, Object> loginOut(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//删除cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null){  
		  //删除.dovip.top下面的cookie
		  for (Cookie cookie : cookies){  
		      cookie.setPath("/");//设置成跟写入cookies一样的  
		      cookie.setDomain(".dovip.top");//设置成跟写入cookies一样的  
		      cookie.setMaxAge(0);  
		      response.addCookie(cookie);  
		  }
		}  
		
		//删除session
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
