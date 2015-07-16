package com.yiyong.baseproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yiyong.baseproject.entity.Test;
import com.yiyong.baseproject.service.TestService;
import com.yiyong.framework.core.orm.Page;
/**
 * 
 * @author zhoudong
 *
 */
@Controller
public class TestController {
	@Resource
	private TestService testService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "index", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	/**
	 * 保存
	 * @return
	 */
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> save(@RequestParam String code,@RequestParam String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Test test = new Test();
			test.setCode(code);
			test.setName(name);
			testService.save(test);
			map.put("respCode", 0);
			map.put("respMsg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
			map.put("respMsg", "保存失败");
		}
		
		return map;
	}
	
	/**
	 * 根据code查询
	 * http://localhost:9080/baseproject/get/11
	 * @return
	 */
	@RequestMapping(value = "/get/{code}", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> get(@PathVariable String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		Test test = testService.findByCode(code);
		map.put("result", test);
		return map;
	}
	
	/**
	 * 查询全部
	 * http://localhost:9080/baseproject/getAll
	 * @return
	 */
	@RequestMapping(value = "/getAll", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Test> tests = testService.findAll();
		map.put("result", tests);
		return map;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping(value = "/getByPage/{pageNo}/{pageSize}", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> findByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Test> page = new Page<Test>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		testService.findByPage(page);
		map.put("result", page);
		return map;
	}
}
