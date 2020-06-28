package com.ruoyi.wsdl.esbSendMessage;

import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by zhangxin19 on 2016/2/24.
 */
//@Component
public class HttpClientUtil {
    private static int seq = 0;

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static final int CONNTIMEOUT = 10000;
    public static final int READTIMEOUT = 10000;
    public static final String CHARSET = "UTF-8";

    private static HttpClient client = null;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(128);
        cm.setDefaultMaxPerRoute(128);
        client = HttpClients.custom().setConnectionManager(cm).build();
    }

    /**
     * 发送一个 Post 请求，使用指定的字符集编码
     *
     * @param body        RequestBody
     * @return ResponseBody 使用指定的字符集编码
     * @throws ConnectTimeoutException 建立链接超时异常
     * @throws SocketTimeoutException  响应超时
     * @throws Exception
     */
    public static String post(String body) throws ConnectTimeoutException, SocketTimeoutException, Exception {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
//    			headerMap.put("cache-control", "no-cache");
        headerMap.put("Content-type", "text/xml");
        //测试
         String url = "http://66.2.43.83/api/v2/jsb/webservice/PushMessageService?wsdl";
        //生产
        //String url = "http://88.1.48.184/api/v2/jsb/webservice/PushMessageService?wsdl";
        String mimeType = "text/xml";
        String CHARSET = "UTF-8";
        int CONNTIMEOUT = 10000;
        int READTIMEOUT = 10000;
        logger.info("发送HTTP(S) POST 请求：" +  url + " | " + mimeType + " | " + CHARSET + " | " + CONNTIMEOUT + " | " + READTIMEOUT);

        HttpClient client = null;
        HttpResponse res = null;
        HttpPost post = new HttpPost(url);
        String result = null;
        try {
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, ContentType.create(mimeType, CHARSET));
                post.setEntity(entity);
            }
            if (headerMap != null && !headerMap.isEmpty()) {
                for (Entry<String, String> entry : headerMap.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            customReqConf.setConnectTimeout(CONNTIMEOUT);
            customReqConf.setSocketTimeout(READTIMEOUT);
            post.setConfig(customReqConf.build());

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(post);
            }
            if (res.getStatusLine().getStatusCode() == 200) {
//            	org.apache.http.Header header=res.getFirstHeader("Content-Type");
//			    String ContentType=header.getValue();
//			    System.out.println("ContentType为:"+ContentType);
//			    org.apache.http.Header header2=res.getFirstHeader("Error-Code");
//			    String ErrorCode=header2.getValue();
//			    logger.info("Error-Code为:"+ErrorCode);
                result = IOUtils.toString(res.getEntity().getContent(), CHARSET);
            } else {
                logger.info("HTTP(S) POST 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                result = "<StatusCode>"+res.getStatusLine().getStatusCode()+"</StatusCode>";
            }
        } finally {
            post.abort();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        int statusCode = res.getStatusLine().getStatusCode();
        System.out.println("返回码：" + statusCode);
        return result;
    }

    /**
     * 发送一个 Put 请求，使用指定的字符集编码
     *
     * @param url
     * @param body        RequestBody
     * @param mimeType    例如 application/xml "application/x-www-form-urlencoded" a=1&b=2&c=3 application/json
     * @param CHARSET     编码
     *
     * @param CONNTIMEOUT 建立链接超时时间（毫秒）
     * @param READTIMEOUT 响应超时时间（毫秒）
     * @return ResponseBody 使用指定的字符集编码
     * @throws ConnectTimeoutException 建立链接超时异常
     * @throws SocketTimeoutException  响应超时
     * @throws Exception
     */
    public static String put(String url, String body, String mimeType, String CHARSET, Integer CONNTIMEOUT, Integer READTIMEOUT) throws ConnectTimeoutException, SocketTimeoutException, Exception {
        logger.info("发送HTTP(S) POST 请求：" +  url + " | " + mimeType + " | " + CHARSET + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpClient client = null;
        HttpResponse res = null;
        HttpPut put = new HttpPut(url);
        String result = null;
        try {
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, ContentType.create(mimeType, CHARSET));
                put.setEntity(entity);
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            if (CONNTIMEOUT != null) {
                customReqConf.setConnectTimeout(CONNTIMEOUT);
            }
            if (READTIMEOUT != null) {
                customReqConf.setSocketTimeout(READTIMEOUT);
            }
            put.setConfig(customReqConf.build());

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(put);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(put);
            }
            if (res.getStatusLine().getStatusCode() == 200) {
                result = IOUtils.toString(res.getEntity().getContent(), CHARSET);
            } else {
                logger.info("HTTP(S) PUT 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                result =null;
            }
        } finally {
            put.abort();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 提交Form表单
     *
     * @param url
     * @param params
     * @param CONNTIMEOUT
     * @param READTIMEOUT
     * @return ResponseBody 使用指定的字符集编码
     * @throws ConnectTimeoutException
     * @throws SocketTimeoutException
     * @throws Exception
     */
    public static String postForm(String url, Map<String, String> params, Map<String, String> headers, Integer CONNTIMEOUT, Integer READTIMEOUT) throws ConnectTimeoutException, SocketTimeoutException, Exception {
        logger.info("发送HTTP(S) POST 请求：" + url + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpClient client = null;
        HttpResponse res = null;
        HttpPost post = new HttpPost(url);
        String result = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                Set<Entry<String, String>> entrySet = params.entrySet();
                for (Entry<String, String> entry : entrySet) {
                    formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
                post.setEntity(entity);
            }
            if (headers != null && !headers.isEmpty()) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            if (CONNTIMEOUT != null) {
                customReqConf.setConnectTimeout(CONNTIMEOUT);
            }
            if (READTIMEOUT != null) {
                customReqConf.setSocketTimeout(READTIMEOUT);
            }
            post.setConfig(customReqConf.build());

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(post);
            }
            if (res.getStatusLine().getStatusCode() == 200) {
                result = IOUtils.toString(res.getEntity().getContent(), CHARSET);
            } else {
                logger.info("HTTP(S) POST 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                result = null;
            }
        } finally {
            post.abort();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null
                    && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 发送一个 GET 请求
     *
     * @param url
     * @param CHARSET
     * @param CONNTIMEOUT 建立链接超时时间（毫秒）
     * @param READTIMEOUT 响应超时时间（毫秒）
     * @return
     * @throws ConnectTimeoutException 建立链接超时
     * @throws SocketTimeoutException  响应超时
     * @throws Exception
     */
    public static String get(String url, String CHARSET, Integer CONNTIMEOUT, Integer READTIMEOUT) throws ConnectTimeoutException, SocketTimeoutException, Exception {
        logger.info("发送HTTP(S) GET 请求：" + url + " | " + CHARSET + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpClient client = null;
        HttpResponse res = null;
        HttpGet get = new HttpGet(url);
        String result = null;
        try {
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            if (CONNTIMEOUT != null) {
                customReqConf.setConnectTimeout(CONNTIMEOUT);
            }
            if (READTIMEOUT != null) {
                customReqConf.setSocketTimeout(READTIMEOUT);
            }
            get.setConfig(customReqConf.build());

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(get);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(get);
            }
            if (res.getStatusLine().getStatusCode() == 200) {
                result = IOUtils.toString(res.getEntity().getContent(), CHARSET);
            } else {
                logger.info("HTTP(S) GET 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                result = "<StatusCode>"+res.getStatusLine().getStatusCode()+"</StatusCode>"+"<StatusCodeMSG>"+"HTTP(S) POST 请求，状态异常：请联系外联ESB开发人员"+"</StatusCodeMSG>";
            }
        } finally {
            get.abort();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 创建 SSL连接
     *
     * @return
     * @throws GeneralSecurityException
     */
    private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
        Builder requestBuilder = RequestConfig.custom();
        requestBuilder = requestBuilder.setSocketTimeout(CONNTIMEOUT);
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER))
                .setDefaultRequestConfig(requestBuilder.build())
                .setSSLHostnameVerifier(new DefaultHostnameVerifier()).build();
        return client;
    }

    public static String getSoapStr(List<String> userIdList, String itemValue,String title ,String appUrl) {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String data = df.format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String seqNo = getSeqNo();
        logger.info("流水号："+ seqNo);
        //传入userId
        String join = String.join(",", userIdList);

        StringBuffer sb = new StringBuffer();
        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pus=\"http://www.jscb.com.cn/mxmop/type/PushMessageService/\">\n");
        sb.append("<soapenv:Header/>");
        sb.append("<soapenv:Body>");
        sb.append("<pus:pushMessage>");
        sb.append("<arg0>");
        sb.append("<SEQ_NO>");
        sb.append(seqNo);
        sb.append("</SEQ_NO>");
        sb.append("<SERVICE_ID>");
        sb.append("MXMOP0101");
        sb.append("</SERVICE_ID>");
        sb.append("<CHANNEL_ID>");
        sb.append("8249");
        sb.append("</CHANNEL_ID>");
        sb.append("<SERVER_ID>");
        sb.append("8174");
        sb.append("</SERVER_ID>");
        sb.append("<BANK_CODE>");
        sb.append("999999");
        sb.append("</BANK_CODE>");
        sb.append("<USER_ID>");
        sb.append("999999");
        sb.append("</USER_ID>");
        sb.append("<AUTH_ID>");
        sb.append("admin");
        sb.append("</AUTH_ID>");
        sb.append("<TRAN_DATE>");
        sb.append(data);
        sb.append("</TRAN_DATE>");
        sb.append("<TRAN_TIME>");
        sb.append(sdf.format(new Date()));
        sb.append("</TRAN_TIME>");
        sb.append("<AUTH_CONTEXT/>");
        sb.append("<TRAN_TERM/>");
        sb.append("<EXT_HEAD>");
        sb.append("<MAC_INDEX/>");
        sb.append("<MAC_VALUE/>");
        sb.append("<BUSINESS_ID>");
        sb.append("50340");
        sb.append("</BUSINESS_ID>");
        sb.append("<PIN_SEED></PIN_SEED>");
        sb.append("</EXT_HEAD>");
        sb.append("<DIRECT_TO_USER_LIST>");
        sb.append("<USER>");
        sb.append("<USER_ID>");
        sb.append(join);
        logger.info("员工ID：" + userIdList);
        sb.append("</USER_ID>");
        sb.append("</USER>");
        sb.append("</DIRECT_TO_USER_LIST>");
        sb.append("<TITLE>");
        sb.append(title);
        sb.append("</TITLE>");
        sb.append("<ITEM_LIST>");
        sb.append("<ITEM>");
        sb.append("<ITEM_KEY>");
        sb.append("");
        sb.append("</ITEM_KEY>");
        sb.append("<ITEM_VALUE>");
        sb.append(itemValue);
        logger.info("发送内容：" + itemValue);
        sb.append("</ITEM_VALUE>");
        sb.append("</ITEM>");
        sb.append("</ITEM_LIST>");
        sb.append("<URL/>");
        sb.append("<APP_URL>");
        sb.append(appUrl);
        logger.info("页面地址：" + appUrl);
        sb.append("</APP_URL>");
        sb.append("<PUSH_TIME/>");
        sb.append("</arg0>\n");
        sb.append("</pus:pushMessage>\n");
        sb.append("</soapenv:Body>\n");
        sb.append("</soapenv:Envelope>");
        return  sb.toString();
    }

    public static String getSeqNo(){
        synchronized (logger){
            seq = seq < 999 ? ++seq : 0;
        }
        DecimalFormat df = new DecimalFormat("000");
        return String.valueOf(System.currentTimeMillis())+df.format(seq);
    }

//
//    public static void main(String[] args) throws Exception{
//        System.out.println(post(getSoapStr()));
//    }
}
