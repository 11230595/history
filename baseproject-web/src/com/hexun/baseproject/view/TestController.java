package com.hexun.baseproject.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.baseproject.constants.Constants;
import com.hexun.baseproject.entity.Test;
import com.hexun.baseproject.service.TestService;
import com.hexun.framework.core.utils.IDUtils;
/**
 * 首页
 * @author zhoudong
 *
 */
@Controller
public class TestController {
	private static Logger logger = Logger.getLogger(TestController.class);
	@Resource
	private TestService testService;
	
	/**
	 * add
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> add(@RequestParam(required=false) String code,
			@RequestParam String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		Test test = new Test();
		test.setId(IDUtils.getId());
		test.setCode(code);
		test.setName(name);
		try {
			testService.insert(test);
			map.put("respCode", 0);
			map.put("respMsg", "保存成功");
		} catch (Exception e) {
			map.put("respCode", 1);
			map.put("respMsg", "保存失败");
		}
		
		return map;
	}
	
	/**
	 * get
	 * @return
	 */
	@RequestMapping(value="get/{code}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findByCode(@PathVariable String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		Test test = testService.findByCode(code);
		map.put("result", test);
		return map;
	}
	
	
	/**
	 * getByNameOrCode
	 * @return
	 */
	@RequestMapping(value="getByNameOrCode",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findByNameOrCode(
			@RequestParam(required=false) String name,@RequestParam(required=false) String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Test> test = testService.findByNameOrCode(name,code);
		map.put("result", test);
		return map;
	}
	/**
	 * page
	 * 跳转页面
	 * @return
	 */
	@RequestMapping(value="page",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(@RequestParam String code) {
		return new ModelAndView("index","code",code);
	}
}
