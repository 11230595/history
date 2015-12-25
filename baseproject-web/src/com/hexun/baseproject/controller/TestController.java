package com.hexun.baseproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.baseproject.entity.Test;
import com.hexun.baseproject.service.TestService;
import com.hexun.framework.core.controller.DefaultBaseController;
import com.hexun.framework.core.utils.IDUtils;
/**
 * 测试
 * @author zhoudong
 *
 */
@Controller
public class TestController extends DefaultBaseController{
	/**
	 * 日志，
	 * 可用级别有4级
	 * 	logger.debug("");
		logger.info("");
		logger.warn("");
		logger.error("");
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 注入，实例由spring管理，无需new,无需配置文件
	 */
	@Resource
	private TestService testService;
	
	/**
	 * add
	 * 访问路径  localhost:8080/baseproject-web/add.do?code=hexun&name=和讯
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> add(@RequestParam(required=false) String code,
			@RequestParam String name) {
		Test test = new Test();
		test.setId(IDUtils.getId());
		test.setCode(code);
		test.setName(name);
		try {
			testService.insert(test);
			resultMap.put("respCode", 0);
			resultMap.put("respMsg", "保存成功");
		} catch (Exception e) {
			resultMap.put("respCode", 1);
			resultMap.put("respMsg", "保存失败");
		}
		return resultMap;
	}
	
	/**
	 * get
	 * @return
	 */
	@RequestMapping(value="get",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findByCode(@RequestParam String code) {
		Test test = testService.findByCode(code);
		logger.info("code:{},查询到的结果:{}",code,JSONObject.fromObject(test).toString());
		resultMap.put("result", test);
		return resultMap;
	}
	
	/**
	 * test
	 * @return
	 */
	@RequestMapping(value="test",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> test() {
		System.out.println(getRequest().getParameter("user"));
		System.out.println(getWebApplicationAbsolutePath(getRequest()));
		resultMap.put("aaa", 111);
		System.out.println(resultMap.get("aaa"));
		return resultMap;
	}
	/**
	 * getByNameOrCode
	 * @return
	 */
	@RequestMapping(value="getByNameOrCode",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findByNameOrCode(
			@RequestParam(required=false) String name,@RequestParam(required=false) String code) {
		List<Test> test = testService.findByNameOrCode(name,code);
		resultMap.put("result", test);
		return resultMap;
	}
	/**
	 * page
	 * 跳转页面
	 * http://localhost:8080/baseproject-web/page.do?code=11
	 * @return
	 */
	@RequestMapping(value="page",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(@RequestParam String code) {
		return getModelAndView("index", "code", code);
	}
	
	/**
	 * 获取参数测试
	 * http://localhost:8080/baseproject-web/param.do?code=11
	 * @return
	 */
	@RequestMapping(value="param",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView param() {
		String code = getRequest().getParameter("code");
		String sessionUser = String.valueOf(getSession().getAttribute("user"));
		return getModelAndView("param", "code", code,"sessionUser",sessionUser);
	}
}
