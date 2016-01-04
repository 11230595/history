package com.hexun.personalcms.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hexun.framework.core.utils.DateUtils;
import com.hexun.personalcms.utils.ImageUtil;
/**
 * 上传图片
 * @author zhoudong
 *
 */
@Controller
public class UploadPhotoController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 上传图片
	 */
	@RequestMapping(value="upload/photo", method = RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, String> upload(HttpServletRequest request){

		Map<String, String> jsonMap=new HashMap<String, String>();
		
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        MultipartFile attachFile  =  multipartRequest.getFile("photo");  
        
		//判断图片大小
		if ((multipartRequest.getContentLength()/1024)/1024 > 30) {
			jsonMap.put("req_code", "3");
			jsonMap.put("req_mess", "请上传小于30M的图片");
			
			return jsonMap;
		}
 
        //上传文件后缀名称
		String extendName = attachFile.getOriginalFilename().substring(attachFile.getOriginalFilename().lastIndexOf("."));
		//新文件名称
		String newFileName = UUID.randomUUID().toString() + extendName;

		try
		{
			//应用的真实路径
			String realContextPath = request.getSession().getServletContext().getRealPath("/");
 			String relativePath = "upload/" + DateUtils.getDate(new Date());
			// 新文件所属目录
			File destFile = new File(realContextPath + relativePath);
			if (!destFile.exists()){
				destFile.mkdirs();
			}
			
 			// 新文件
			File normalFile = new File(destFile, newFileName);
			attachFile.transferTo(normalFile);    

			
			String smallRelativePath = null;
			Integer[] picSize = new Integer[] { 0, 0 };
				
			//===============进行图片压缩start==================
			//压缩后图片目录
			smallRelativePath = relativePath + "/" + "small";
			File smallDestFile = new File(realContextPath + smallRelativePath);
			if (!smallDestFile.exists()) 
			{
				smallDestFile.mkdirs();				
			}
			//压缩后图片
			File smallFile = new File(smallDestFile, newFileName);
			picSize = ImageUtil.generateSmallImg(normalFile.getAbsolutePath(), smallFile.getAbsolutePath());
			//===============压缩end===========================
			
			jsonMap.put("req_code", "0");
			jsonMap.put("req_mess", "文件上传成功");
			jsonMap.put("fileURL", smallRelativePath+"/"+newFileName);
			
			logger.info("上传图片成功，返回参数：{}",JSONObject.fromObject(jsonMap).toString());
		} catch (Exception e) {
			e.printStackTrace();
			jsonMap.put("req_code", "1");
			jsonMap.put("req_mess", "文件上传失败");
		}
        
        return jsonMap;
	}
	
}
