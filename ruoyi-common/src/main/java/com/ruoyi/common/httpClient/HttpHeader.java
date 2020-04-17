package com.ruoyi.common.httpClient;

import com.ruoyi.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *传输数据类型
 * @author mengdehu
 * @since  2019-11-12
 */
public class HttpHeader {

    /**
     * form-data 格式传输数据
     * @param identity
     * @param token
     * @return
     */
    public static Map headerMap1(String identity,String token){
        Map<String,String> map = new HashMap<>();
        map.put("Connection","Keep-Alive");
        map.put("Charset","UTF-8");
        //map.put("Content-Type","application/x-www-form-urlencoded");
        map.put("Content-Type","application/json");
        //map.put("Charset","");
        /*map.put("identity",identity);
        map.put("token",token);*/
        return map;
    }

    public static Map headerMap(String identity,String token){
        Map<String,String> map = new HashMap<>();
        map.put("Connection","Keep-Alive");
        map.put("Charset","UTF-8");
        map.put("Content-Type","application/x-www-form-urlencoded");
        //map.put("Charset","");
        map.put("identity",identity);
        map.put("token",token);
        return map;
    }

    public static Map headerMap(String token){
        Map<String,String> map = new HashMap<>();
        map.put("Connection","Keep-Alive");
        map.put("Charset","UTF-8");
        map.put("Content-Type","application/json");
        if (StringUtils.isNotBlank(token)){
            map.put("st_auth_token",token);
        }
        return map;
    }

}
