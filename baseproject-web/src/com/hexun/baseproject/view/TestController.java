package com.hexun.baseproject.view;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.baseproject.constants.Constants;
import com.hexun.baseproject.entity.Test;
import com.hexun.baseproject.service.TestService;
import com.hexun.framework.core.utils.IDUtils;
/**
 * 测试
 * @author zhoudong
 *
 */
@Controller
public class TestController {
	private static Logger logger = Logger.getLogger(TestController.class);
	@Resource
	private TestService testService;
	
	/**
	 * 测试添加
	 * url
	 * localhost:8080/baseproject-web/add/zhou/dong
	 * @return
	 */
	@RequestMapping(value="add/{name}/{code}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> index(@PathVariable String name,@PathVariable String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		Test test = new Test();
		test.setId(IDUtils.getId());
		test.setName(name);
		test.setCode(code);
		try {
			testService.insert(test);
			map.put("respCode", 0);
			map.put("respMsg", "保存成功..");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
			map.put("respMsg", "保存失败..");
		}
		
		return map;
	}
	
}
