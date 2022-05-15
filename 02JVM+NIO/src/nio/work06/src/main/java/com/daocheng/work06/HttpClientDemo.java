package com.daocheng.work06;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 通过HttpClient访问url
 */
public class HttpClientDemo {
    public static void main(String[] args) throws IOException {

        byte[] bytes = getBody1( "http://localhost:8801");
        System.out.println(new String(bytes));

    }

    /**
     * 获取body字节数组
     * @param url 地址
     * @return body字节数组
     */
    private static byte[] getBody1(String url){
        HttpGet httpGet = new HttpGet(url); //get
        httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault(); //建立客户端
            response = httpClient.execute(httpGet);  //获取response
            HttpEntity entity = response.getEntity(); //获取entity
            // System.out.println(EntityUtils.toString(entity));
            return EntityUtils.toByteArray(entity); //转为byte数组
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
                httpGet.releaseConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
