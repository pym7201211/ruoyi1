package com.ruoyi.common.httpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * HTTP工具类 发送http/https协议get/post请求，发送map，json，xml，txt数据
 * 
 * @author mengdehu
 * @since 2019-11-12
 */
public final class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);

	/**
	 * 执行一个http/https get请求，返回请求响应的文本数据
	 * 
	 * @param url
	 *            请求的URL地址，可以带参数?param1=a&parma2=b
	 * @param headerMap
	 *            请求头参数map，可以为null
	 * @param paramMap
	 *            请求参数map，可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的文本数据
	 */
	public static String doGet(String url, Map<String, String> headerMap, Map<String, String> paramMap, String charset,
			boolean pretty) {
		String responseContent = "";
		// http客户端
		CloseableHttpClient httpclient = null;
		// Get请求
		HttpGet httpGet = null;
		// http响应
		CloseableHttpResponse response = null;
		try {
			if (url.startsWith("https")) {
				httpclient = HttpsSSLClient.createSSLInsecureClient();
			} else {
				httpclient = HttpClients.createDefault();
			}
			// 设置参数
			if (paramMap != null) {
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
					} else {
						log.info("param is null key:" + entry.getKey() + "value:" + entry.getValue());
					}
				}
				url = url + "?" + URLEncodedUtils.format(nvps, charset);
			}
			// Get请求
			httpGet = new HttpGet(url); // HttpUriRequest httpGet
			// 设置header
			if (headerMap != null) {
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						httpGet.addHeader(entry.getKey(), entry.getValue());
					} else {
						log.info("header is null key:" + entry.getKey() + "value:" + entry.getValue());
					}
				}
			}
			// 发送请求，返回响应
			response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, charset);
			}
		} catch (ClientProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpGet != null) {
					httpGet.releaseConnection();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return responseContent;
	}

	/**
	 * 执行一个http/https post请求，返回请求响应的文本数据
	 * 
	 * @param url
	 *            请求的URL地址，可以带参数?param1=a&parma2=b
	 * @param headerMap
	 *            请求头参数map，可以为null
	 * @param paramMap
	 *            请求参数map，可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的文本数据
	 */
	public static String doPost1(String url, Map<String, String> headerMap, Map<String, String> paramMap, String charset,
								boolean pretty) {
		String responseContent = "";
		// http客户端
		CloseableHttpClient httpclient = null;
		// Post请求
		HttpPost httpPost = null;
		// http响应
		CloseableHttpResponse response = null;
		try {

			if (url.startsWith("https")) {
				httpclient = HttpsSSLClient.createSSLInsecureClient();
				//httpclient = HttpsSSLClient.buildSSLCloseableHttpClient();
			} else {
				httpclient = HttpClients.createDefault();
			}

			// Post请求
			httpPost = new HttpPost(url);
			httpPost.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10 * 1000);
			// 设置header
			if (headerMap != null) {
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						httpPost.addHeader(entry.getKey(), entry.getValue());
					} else {
						log.info("header is null key:" + entry.getKey() + "value:" + entry.getValue());
					}

				}
			}

			// 设置参数
			if (paramMap != null) {
				com.ruoyi.common.json.JSONObject json = new com.ruoyi.common.json.JSONObject();
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						json.put(entry.getKey(), entry.getValue())	;
					} else {
						log.info("param is null key:" + entry.getKey() + "value:" + entry.getValue());
					}
				}
				//String param1="valid_date1="+paramMap.get("valid_date1")+"&valid_date2="+paramMap.get("valid_date2");
				//StringEntity entity = new StringEntity(param1);
				StringEntity entity = new StringEntity(json.toString(),charset);
				entity.setContentEncoding(charset);
				entity.setContentType("application/json");
				//entity.setContentType("application/x-www-form-urlencoded");

				httpPost.setEntity(entity);
			}
			// 发送请求，返回响应
			log.info("dasdasdsada"+httpPost);

			response = httpclient.execute(httpPost);
			log.info("==========>>> "+response.getStatusLine().getStatusCode()
					+"      ===========>>>"+HttpStatus.SC_OK);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, charset);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		} catch (ClientProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpPost != null) {
					httpPost.releaseConnection();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return responseContent;
	}

	/**
	 * 执行一个http/https post请求，返回请求响应的文本数据
	 *
	 * @param url
	 *            请求的URL地址，可以带参数?param1=a&parma2=b
	 * @param headerMap
	 *            请求头参数map，可以为null
	 * @param paramMap
	 *            请求参数map，可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的文本数据
	 */
	public static String doPost(String url, Map<String, String> headerMap, Map<String, String> paramMap, String charset,
								boolean pretty) {
		String responseContent = "";
		// http客户端
		CloseableHttpClient httpclient = null;
		// Post请求
		HttpPost httpPost = null;
		// http响应
		CloseableHttpResponse response = null;
		try {

			if (url.startsWith("https")) {
				httpclient = HttpsSSLClient.createSSLInsecureClient();
				//httpclient = HttpsSSLClient.buildSSLCloseableHttpClient();
			} else {
				httpclient = HttpClients.createDefault();
			}

			// Post请求
			httpPost = new HttpPost(url);
			httpPost.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10 * 1000);
			// 设置header
			if (headerMap != null) {
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						httpPost.addHeader(entry.getKey(), entry.getValue());
					} else {
						log.info("header is null key:" + entry.getKey() + "value:" + entry.getValue());
					}

				}
			}

			// 设置参数
			if (paramMap != null) {
				com.ruoyi.common.json.JSONObject json = new com.ruoyi.common.json.JSONObject();
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						json.put(entry.getKey(), entry.getValue())	;
					} else {
						log.info("param is null key:" + entry.getKey() + "value:" + entry.getValue());
					}
				}
				String param1="valid_date1="+paramMap.get("valid_date1")+"&valid_date2="+paramMap.get("valid_date2");
				StringEntity entity = new StringEntity(param1);
				/*entity.setContentEncoding(charset);
				entity.setContentType("application/json");*/
				entity.setContentType("application/x-www-form-urlencoded");

				httpPost.setEntity(entity);
			}
			// 发送请求，返回响应
			log.info("dasdasdsada"+httpPost);

			response = httpclient.execute(httpPost);
			log.info("==========>>> "+response.getStatusLine().getStatusCode()
					+"      ===========>>>"+HttpStatus.SC_OK);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, charset);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		} catch (ClientProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpPost != null) {
					httpPost.releaseConnection();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return responseContent;
	}

	/**
	 * 执行一个http/https post请求， 直接写数据 json,xml,txt
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param headerMap
	 *            请求头参数map，可以为null
	 * @param content
	 *            json或xml等字符串内容
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的文本数据
	 */
	public static String writePost(String url, Map<String, String> headerMap, String content, String charset,
			boolean pretty) {
		String responseContent = "";
		// http客户端
		CloseableHttpClient httpclient = null;
		// Post请求
		HttpPost httpPost = null;
		// http响应
		CloseableHttpResponse response = null;
		try {

			if (url.startsWith("https")) {
				httpclient = HttpsSSLClient.createSSLInsecureClient();
			} else {
				httpclient = HttpClients.createDefault();
			}
			// Post请求
			httpPost = new HttpPost(url);
			// 设置header
			if (headerMap != null) {
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						httpPost.addHeader(entry.getKey(), entry.getValue());
					} else {
						log.info("header is null key:" + entry.getKey() + "value:" + entry.getValue());
					}
				}
			}
			// 字符串Entity
			StringEntity stringEntity = new StringEntity(content, charset);
			stringEntity.setContentType("text/plain"); // application/json,text/xml,text/plain
			httpPost.setEntity(stringEntity);
			// 发送请求，返回响应
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, charset);
			}
			// EntityUtils.consume(entity);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		} catch (ClientProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpPost != null) {
					httpPost.releaseConnection();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return responseContent;

	}

	public static void aa(){
		HashMap<String,String> map = new HashMap<>();
		map.put("Connection","Keep-Alive");
		map.put("Charset","UTF-8");
		map.put("Content-Type","application/x-www-form-urlencoded");
		map.put("identity","487");
		map.put("token","api@jsyh@123@abc");
		HashMap<String,String> map1 = new HashMap<>();
		map1.put("login","01010700");
		doPost("",map,map1,"UTF-8",false);
	}

}
