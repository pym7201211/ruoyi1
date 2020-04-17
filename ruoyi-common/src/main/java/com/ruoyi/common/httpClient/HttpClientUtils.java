package com.ruoyi.common.httpClient;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;


public class HttpClientUtils {
    private static Log log = LogFactory.getLog(HttpClientUtils.class);
    private final static String charset = "UTF-8";
    private final static String scheme = "https";
    private final static String sc_code = "204";

    public static String doPut(String hostname,String url,Map<String,String> headerMap,Map<String,String> paramMap) throws Exception {
        try{
            String resultStr = "";
            HttpHost host = new HttpHost(hostname, 443, scheme);
            HttpPut httpPut = new HttpPut(url);
            httpPut = addHeader(httpPut, headerMap);
            String jsonStr = addJson(paramMap);
            HttpEntity entity = new StringEntity(jsonStr, charset);
            httpPut.setEntity(entity);
            HttpClient httpClient = CreateHttpClientSSL.createHttpClient();
            HttpResponse getResp = httpClient.execute(host, httpPut);
            log.info("get response code : " + getResp.getStatusLine().getStatusCode() +" sc_ok : "+HttpStatus.SC_OK);
            if (sc_code.equals(String.valueOf(getResp.getStatusLine().getStatusCode()))) {
                resultStr = sc_code;
                //log.info("get response is : " + EntityUtils.toString(getResp.getEntity()));
            }
            return resultStr;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static Map<String,String> headerMap(String token) throws Exception {
        try{
            Map<String,String> map = new HashMap<>();
            map.put("accept", "application/json");
            map.put("Content-Type", "application/json;charset=UTF-8");
            map.put("st-auth-token", token);
            return map;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static HttpPut addHeader(HttpPut httpPut,Map<String, String> headerMap) throws Exception {
        try{
            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        httpPut.addHeader(entry.getKey(), entry.getValue());
                    } else {
                        log.info("header is null key:" + entry.getKey() + "value:" + entry.getValue());
                    }
                }
            }
            return httpPut;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String addJson(Map<String, String> paramMap) throws Exception {
        try{
            JSONObject json = new JSONObject();
            if (paramMap != null) {
                for (Map.Entry<String,String> entry : paramMap.entrySet()){
                    if (null != entry.getKey() && null != entry.getValue()){
                        json.put(entry.getKey(),entry.getValue());
                    }else {
                        log.info("header is null key:" + entry.getKey() + "value:" + entry.getValue());
                    }
                }
            }
            return json.toString();
        }catch (Exception e){
            throw new Exception(e);
        }
    }


}
