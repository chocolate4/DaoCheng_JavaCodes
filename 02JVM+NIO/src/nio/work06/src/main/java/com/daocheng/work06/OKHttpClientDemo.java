package com.daocheng.work06;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 通过OKHttp访问url
 */
public class OKHttpClientDemo {
    private static OkHttpClient client = new OkHttpClient();
    public static void main(String[] args) throws IOException {
        getBody1(client, "http://localhost:8801");
        client = null;
    }

    /**
     * 获取body
     * @param client OKhttp客户端
     * @param url 地址
     */
    private static void getBody1(OkHttpClient client, String url){

        //建立请求
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        //String body = "test";
        try {
            //获取respone
            Response response = client.newCall(request).execute();
            //获取body，转为string
            String responseData = response.body().string();
            //打印
            System.out.println(responseData);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            client = null;
        }
    }
}
