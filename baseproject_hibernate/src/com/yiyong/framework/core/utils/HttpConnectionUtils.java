package com.yiyong.framework.core.utils;

 
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpConnectionUtils {

	/**
	 * 
	 * @param url 请求url地址,例如：http://g.cn?q=1
	 * @return 
	 */
	public static String get(String url) 
	{
		return get(url, null, null);
	}
	
	/**
	 * 
	 * @param url 请求url地址,例如http://g.cn
	 * @param params 请求参数Map
	 * @return
	 */
	public static String get(String url, Map<String, String> params)
	{
		return get(url, params, null);
	}
	
	/**
	 * 
	 * @param url 请求url地址,例如http://g.cn
	 * @param params 请求参数Map
	 * @param charset  对参数值进行编码
	 * @return
	 */
	public static String get(String url, Map<String, String> params,String charset) 
	{
		if  (StringUtils.isBlank(url)) 
		{
			return null;
		}
		
		charset = (StringUtils.isBlank(charset)  ? Consts.UTF_8.toString() : charset);
		
		List<NameValuePair> qparams = getParamsList(params);
		if (qparams != null && qparams.size() > 0)
		{
			String formatParams = URLEncodedUtils.format(qparams, charset);
	 		url = (url.indexOf("?")) < 0 
					? (url + "?" + formatParams)
					: (url + "&" +  formatParams);  
		}
		
		CloseableHttpClient httpclient = getDefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
  
		// 发送请求，得到响应
		String responseStr = null;
		try
		{
			responseStr = httpclient.execute(httpGet, responseHandler);
		}
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}  
		return responseStr;
	}
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 *            提交地址
	 * @param params
	 *            提交参数集, 键/值对
	 * @return 响应消息
	 */
	public static String post(String url, Map<String, String> params) {
		return post(url, params, null);
	}

	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 *            提交地址
	 * @param params
	 *            提交参数集, 键/值对
	 * @param charset
	 *            参数提交编码集
	 * @return 响应消息
	 */
	public static String post(String url, Map<String, String> params,String charset) {
		if (StringUtils.isBlank(url)) 
		{
			return null;
		}
		
		// 创建HttpClient实例
 		UrlEncodedFormEntity formEntity = null;
 		if (params != null && params.size() > 0)
 		{
 			try {
 				if (StringUtils.isBlank(charset)) 
 				{
 					formEntity = new UrlEncodedFormEntity(getParamsList(params),Consts.UTF_8);
 				} 
 				else 
 				{
 					formEntity = new UrlEncodedFormEntity(getParamsList(params),charset);
 				}
 			} catch (UnsupportedEncodingException e)
 			{
 				e.printStackTrace();
 			}
 		}
		
		
		CloseableHttpClient httpclient = getDefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(formEntity);
 
		// 发送请求，得到响应
		String responseStr = null;
		try {
			responseStr = httpclient.execute(httpPost, responseHandler);
		} catch (ClientProtocolException e) {
			throw new RuntimeException("客户端连接协议错误", e);
		} catch (IOException e) {
			throw new RuntimeException("IO操作异常", e);
		}  
		return responseStr;
	}

	
private static CloseableHttpClient getDefaultHttpClient() {
		
	PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
	// Increase max total connection to 200
	connectionManager.setMaxTotal(200);
	// Increase default max connection per route to 20
	connectionManager.setDefaultMaxPerRoute(20);
	// Increase max connections for localhost:80 to 50
	HttpHost localhost = new HttpHost("locahost", 80);
	connectionManager.setMaxPerRoute(new HttpRoute(localhost), 50);
	
 	 
	RequestConfig requestConfig = RequestConfig.custom()
														.setConnectTimeout(60 * 1000) 
														.setSocketTimeout(60 * 1000)
														.build();

	CloseableHttpClient httpClient = HttpClients.custom()
														.setConnectionManager(connectionManager)
														.setRetryHandler(httpRequestRetryHandler)
														.setDefaultRequestConfig(requestConfig)
														.build();
	
 	return httpClient;
	}

	/**
	 * 拼接请求参数
	 * @param paramsMap
	 * @return
	 */
	private static List<NameValuePair> getParamsList(Map<String, String> paramsMap)
	{
		if (paramsMap == null || paramsMap.size() == 0) 
		{
			return null;
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> map : paramsMap.entrySet())
		{
			params.add(new BasicNameValuePair(map.getKey(), map.getValue()));
		}
		return params;
	}
	
	/**
	 * The simplest and the most convenient way to handle responses is by using the ResponseHandler interface, 
	 * which includes the handleResponse(HttpResponse response) method. 
	 * This method completely relieves the user from having to worry about connection management. 
	 * When using a ResponseHandler, HttpClient will automatically take care of ensuring release of the connection back to the connection manager
	 *  regardless whether the request execution succeeds or causes an exception.
	 */
	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		@Override
		public String handleResponse(HttpResponse  httpResponse)
				throws ClientProtocolException, IOException {
			String result = null;
			HttpEntity entity = httpResponse.getEntity();
			if(entity != null)
			{
				result = EntityUtils.toString(entity, Consts.UTF_8);
			}
 			return result;
		}
	};
	
	/**
	 * In order to enable a custom exception recovery mechanism 
	 * one should provide an implementation of the HttpRequestRetryHandler interface.
	 */
	private static HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
		
		@Override
		public boolean retryRequest(
	            IOException exception,
	            int executionCount,
	            HttpContext context) {
	        if (executionCount >= 5) {
	            // Do not retry if over max retry count
	            return false;
	        }
	        if (exception instanceof InterruptedIOException) {
	            // Timeout
	            return false;
	        }
	        if (exception instanceof UnknownHostException) {
	            // Unknown host
	            return false;
	        }
	        if (exception instanceof ConnectTimeoutException) {
	            // Connection refused
	            return false;
	        }
	        if (exception instanceof SSLException) {
	            // SSL handshake exception
	            return false;
	        }
	        HttpClientContext clientContext = HttpClientContext.adapt(context);
	        HttpRequest request = clientContext.getRequest();
	        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
	        if (idempotent) {
	            // Retry if the request is considered idempotent
	            return true;
	        }
	        return false;
	    }
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result  = HttpConnectionUtils.get("http://www.baidu.com");
 		System.out.println(result);
	}
	
}