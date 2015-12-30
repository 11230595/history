package com.hexun.personalcms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.framework.core.controller.DefaultBaseController;
import com.hexun.framework.core.page.Page;
import com.hexun.framework.core.properties.PropertiesUtils;
import com.hexun.framework.core.utils.IDUtils;
import com.hexun.framework.core.utils.RespEnum;
import com.hexun.framework.core.utils.StringUtils;
import com.hexun.personalcms.entity.TsUser;
import com.hexun.personalcms.service.TsUserService;
/**
 * 首页
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("user")
public class TsUserController extends DefaultBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private TsUserService tsUserService;
	
	/**
	 * 到登录页
	 * @return
	 */
	@RequestMapping(value="login",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login() {
		return getModelAndView("login");
	}
	
	/**
	 * 到注册页
	 * @return
	 */
	@RequestMapping("reg")
	public ModelAndView reg(){
		return getModelAndView("reg");
	}
	/**
	 * 注册用户
	 * @return
	 */
	@RequestMapping(value="saveUser",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveUser(TsUser user){
		
		user.setId(IDUtils.getId());
		user.setCreateTime(new Date());
		user.setLevel(0);

		try {
			tsUserService.insert(user);
			resultMap.put("respCode", RespEnum.RESP_SUCCESS.getCode());
			resultMap.put("respMsg", RespEnum.RESP_SUCCESS.getCnMsg());
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("respCode", RespEnum.RESP_FAIL.getCode());
			resultMap.put("respMsg", RespEnum.RESP_FAIL.getCnMsg());
		}
		return resultMap;
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value="in",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> in(){
		String userCode = getRequest().getParameter("userCode");
		String password = getRequest().getParameter("password");
		
		TsUser user = tsUserService.login(userCode,password);
		if(user == null){
			logger.info("用户不存在或者用户密码为空,用户名：{}，密码：{}",userCode,password );
			resultMap.put("respCode", RespEnum.RESP_FAIL.getCode());
			resultMap.put("respMsg", "登录失败");
		}else {
			getSession().setAttribute("ts_user", user);
			logger.info("登录成功,用户名：{}，密码：{}",userCode,password );
			resultMap.put("respCode", RespEnum.RESP_SUCCESS.getCode());
			resultMap.put("respMsg", "登录成功");
		}
		return resultMap;
	}
	
	/**
	 * 分页查询所有用户，返回json
	 * 带like条件的访问地址
	 * http://localhost:8080/personalcms/user/findByPage.do?pageNo=1&pageSize=2&userCode=a
	 * 不带like条件的访问地址
	 * http://localhost:8080/personalcms/user/findByPage.do?pageNo=1&pageSize=2
	 * @return
	 */
	@RequestMapping(value="findByPage",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findByPage(){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		int pageNo = Integer.parseInt(getRequest().getParameter("pageNo"));
		int pageSize = Integer.parseInt(getRequest().getParameter("pageSize"));
		
		String userCode = getRequest().getParameter("userCode");
		
		if(StringUtils.isNotBlank(userCode)){ //对userCode模糊查询
			logger.info("用户搜索关键字：{}",userCode);
			paramMap.put("userCode", userCode);
		}
		
		Page<TsUser> page = tsUserService.findUserByPage("findUserByPage",paramMap,pageNo,pageSize);
		resultMap.put("result", page);
		return resultMap;
	}
	
	
	/**
	 * 分页查询所有用户，页面展示
	 * @return
	 */
	@RequestMapping(value="page",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView page(){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		ModelAndView mav = getModelAndView("page");
		
		int pageNo = Integer.parseInt(getRequest().getParameter("pageNo"));
		int pageSize = Integer.parseInt(getRequest().getParameter("pageSize"));
		
		String userCode = getRequest().getParameter("userCode");
		
		
		if(StringUtils.isNotBlank(userCode)){ //对userCode模糊查询
			logger.info("用户搜索关键字：{}",userCode);
			paramMap.put("userCode", userCode);
			mav.addObject("keyword", userCode); //用户前台搜索框
		}
		
		Page<TsUser> page = tsUserService.findUserByPage("findUserByPage",paramMap,pageNo,pageSize);
		mav.addObject("users", page);
		return mav;
	}
}
