package com.fxs.fzm.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Title: 封装http get post
 * Description:
 * Copyright: Copyright (c) 2019-08-26 08:40:17
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: zenggq
 */
@Component
public class HttpUtils {

    private static String proxyHost;

    private static int proxyPort;

    @Value("${proxy.host:}")
    public void setProxyHost(String host) {
        proxyHost = host;
    }

    @Value("${proxy.port:}")
    public void setProxyPort(String port) {
        if (!StringUtils.isEmpty(port)) {
            proxyPort = Integer.valueOf(port);
        }
    }

    public static String getProxyHost(){
        return proxyHost;
    }

    public static int getProxyPort(){
        return proxyPort;
    }

    /**
     * get方法
     *
     * @param url
     * @param timeout 超时时间（单位：秒）
     * @return
     */
    public static String doGet(String url, int timeout) {

        String responseBody = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        //有配置代理，使用代理
        RequestConfig requestConfig = null;
        if (!StringUtils.isEmpty(proxyHost)) {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .setProxy(new HttpHost(proxyHost, proxyPort))
                    .build();
        } else {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .build();
        }

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            responseBody = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }

    /**
     * post kv
     *
     * @param url
     * @param data    参数
     * @param timeout 超时时间（单位：秒）
     * @return
     */
    public static String doPost(String url, String data, int timeout) {
        String responseBody = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();

        //有配置代理，使用代理
        RequestConfig requestConfig = null;
        if (!StringUtils.isEmpty(proxyHost)) {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .setProxy(new HttpHost(proxyHost, proxyPort))
                    .build();
        } else {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .build();
        }

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "text/html; chartset=UTF-8");

        if (!StringUtils.isEmpty(data)) {
            // 使用字符串传参
            StringEntity stringEntity = new StringEntity(data, "UTF-8");
            httpPost.setEntity(stringEntity);
        }
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            responseBody = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return responseBody;

    }

    /**
     * json参数方式POST提交
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, JSONObject params, int timeout){
        String strResult = null;
        //有配置代理，使用代理
        RequestConfig requestConfig = null;
        if (!StringUtils.isEmpty(proxyHost)) {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .setProxy(new HttpHost(proxyHost, proxyPort))
                    .build();
        } else {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .build();
        }
        // 1. 获取默认的client实例
        CloseableHttpClient client = HttpClients.createDefault();
        // 2. 创建httppost实例
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        //添加请求头
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        try {
            httpPost.setEntity(new StringEntity(params.toJSONString(),"utf-8"));
            CloseableHttpResponse resp = client.execute(httpPost);
            // 7. 获取响应entity
            HttpEntity respEntity = resp.getEntity();
            strResult = EntityUtils.toString(respEntity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    /**
     * json参数方式POST提交
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map<String, String> headMap, JSONObject params, int timeout){
        String strResult = null;
        //有配置代理，使用代理
        RequestConfig requestConfig = null;
        if (!StringUtils.isEmpty(proxyHost)) {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .setProxy(new HttpHost(proxyHost, proxyPort))
                    .build();
        } else {
            requestConfig = RequestConfig.custom()
                    // 连接超时
                    .setConnectTimeout(timeout)
                    // 请求超时
                    .setConnectionRequestTimeout(timeout)
                    // 允许自动重定向
                    .setSocketTimeout(timeout).setRedirectsEnabled(true)
                    .build();
        }
        // 1. 获取默认的client实例
        CloseableHttpClient client = HttpClients.createDefault();
        // 2. 创建httppost实例
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        //添加请求头
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        if (headMap != null) {
            for(Map.Entry<String, String> entry: headMap.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        try {
            httpPost.setEntity(new StringEntity(params.toJSONString(),"utf-8"));
            CloseableHttpResponse resp = client.execute(httpPost);
            // 7. 获取响应entity
            HttpEntity respEntity = resp.getEntity();
            strResult = EntityUtils.toString(respEntity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

}
