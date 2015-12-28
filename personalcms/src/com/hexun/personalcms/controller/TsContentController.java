package com.hexun.personalcms.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.constraints.Null;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hexun.framework.core.controller.DefaultBaseController;
import com.hexun.framework.core.properties.PropertiesUtils;
import com.hexun.framework.core.utils.IDUtils;
import com.hexun.framework.core.utils.RespEnum;
import com.hexun.personalcms.entity.TsContent;
import com.hexun.personalcms.entity.TsReadCount;
import com.hexun.personalcms.entity.TsUser;
import com.hexun.personalcms.service.TsContentService;
import com.hexun.personalcms.service.TsReadCountService;
/**
 * 内容
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("content")
public class TsContentController extends DefaultBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private TsContentService tsContentService;
	@Resource
	private TsReadCountService tsReadCountService;
	/**
	 * 首页
	 * 访问路径：localhost:8080/personalcms
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index() {
		List<Map<String, Object>> contents = tsContentService.findContentsVO();
		return getModelAndView("index","contents",contents);
	}
	/**
	 * 发布内容页
	 * @return
	 */
	@RequestMapping("pub")
	public ModelAndView pub(){
		return getModelAndView("pub");
	}
	/**
	 * 保存内容
	 * @param tsContent
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> add(TsContent tsContent) {
		
		tsContent.setId(IDUtils.getId());
		tsContent.setCreateTime(new Date());
		tsContent.setDelFlag(0);
		tsContent.setRecom(0);
		
		try {
			tsContentService.insert(tsContent);
			resultMap.put("respCode", RespEnum.RESP_SUCCESS.getCode());
			resultMap.put("respMsg", RespEnum.RESP_SUCCESS.getCnMsg());
			logger.info("保存内容：{}",JSONObject.fromObject(tsContent).toString());
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("respCode", RespEnum.RESP_FAIL.getCode());
			resultMap.put("respMsg", RespEnum.RESP_FAIL.getCnMsg());
		}
		
		return resultMap;
	}
	
	/**
	 * 详情页
	 * @return
	 */
	@RequestMapping("detail")
	public ModelAndView detail(){
		TsContent tsContent = tsContentService.selectByPrimaryKey(getRequest().getParameter("id"));
		saveReadCount(getRequest().getParameter("id"));
		return getModelAndView("details","content",tsContent);
	}
	/**
	 * 保存阅读次数
	 * @param id
	 */
	private synchronized void saveReadCount(String id) {
		
		TsReadCount tsReadCount = tsReadCountService.findTsReadCountByContentId();
		
		tsReadCount = new TsReadCount();
		tsReadCount.setContentId(IDUtils.getId());
		tsReadCount.setCreateTime(new Date());
		
		TsUser user = (TsUser) getSession().getAttribute("tsUser");
		tsReadCount.setUserId(user == null ? "" : user.getId());
		tsReadCount.setContentId(id);
		
		tsReadCountService.insert(tsReadCount);
	}
}
