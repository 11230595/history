package com.hexun.jndi.view;

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
import com.hexun.jndi.entity.Demo;
import com.hexun.jndi.service.DemoService;
/**
 * 首页
 * @author zhoudong
 *
 */
@Controller
public class DemoController {
	private static Logger logger = Logger.getLogger(DemoController.class);
	@Resource
	private DemoService demoService;
	
	/**
	 * add
	 * http://localhost:8080/baseproject-web/demo/add?code=01&name=hexun
	 * @return
	 */
	@RequestMapping(value="demo/add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> add(@RequestParam(required=false) String code,
			@RequestParam String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		Demo demo = new Demo();
		demo.setId(IDUtils.getId());
		demo.setCode(code);
		demo.setName(name);
		try {
			demoService.insert(demo);
			map.put("respCode", 0);
			map.put("respMsg", "保存成功");
		} catch (Exception e) {
			map.put("respCode", 1);
			map.put("respMsg", "保存失败");
		}
		
		return map;
	}
}
