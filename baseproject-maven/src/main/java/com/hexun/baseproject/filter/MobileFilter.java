package com.hexun.baseproject.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hexun.baseproject.constants.Constants;
/**
 * 判断是否是手机登录
 * @author zhoudong
 *
 */
public class MobileFilter implements Filter{
	private static Logger logger = Logger.getLogger(MobileFilter.class);
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String uri = request.getRequestURI();
		logger.info("filter拦截访问的URI---》" + uri);
		
		String userAgent = request.getHeader("user-agent");  //请求从哪来的
		if(userAgent.contains("Android") || userAgent.contains("iPhone") || 
				userAgent.contains("Windows Phone")){
			List<String> uris = Constants.config.getList("GO_URI");
			for(String goUri : uris){
				if(uri.contains(goUri)){
					logger.info("filter --》 手机访问参数在放行列表中，放行。--》" + uri);
					chain.doFilter(req, resp);
					return;
				}
			}
			
			String client = request.getParameter("client");
			if("PC".equals(client)){
				chain.doFilter(req, resp);
			}
			
			response.sendRedirect(Constants.config.getString("MOBILE_URL"));
		}else {
			chain.doFilter(req, resp);  
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
