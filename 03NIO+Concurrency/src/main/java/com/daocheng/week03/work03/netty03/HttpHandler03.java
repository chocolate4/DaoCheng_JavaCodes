package com.daocheng.week03.work03.netty03;

import com.daocheng.week03.work03.filter.RequestFilter;
import com.daocheng.week03.work03.filter.ResponseFilter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderNames.KEEP_ALIVE;

public class HttpHandler03 extends ChannelInboundHandlerAdapter {

    private static OkHttpClient client = new OkHttpClient();
    private static ResponseFilter responseFilter = new ResponseFilter();
    private static RequestFilter requestFilter = new RequestFilter();

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        try {
            FullHttpRequest fullHttpRequest = (FullHttpRequest) msg; //接受请求
            requestFilter.filter(fullHttpRequest);
            String uri = fullHttpRequest.uri(); //获取url
            if (uri.contains("/test")){
                handlerTest(fullHttpRequest,ctx,"http://localhost:8807");
            }else{
                handlerTest(fullHttpRequest,ctx,"http://localhost:8807");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx,String url){
        FullHttpResponse response = null;
        try {
            //建立请求
            Request request = new Request.Builder()
                    .header("daocheng",fullRequest.headers().get("daocheng"))
                    .get()
                    .url(url)
                    .build();
            System.out.println(request.header("daocheng"));
            Response responseok = client.newCall(request).execute();
            String value = responseok.body().string();
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type","application/json");
            response.headers().setInt("Content-Length",response.content().readableBytes());
            responseFilter.filter(response);
        } catch (UnsupportedEncodingException e) {
            System.out.println("处理出错:"+e.getMessage());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.NO_CONTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fullRequest != null){
                if(!HttpUtil.isKeepAlive(fullRequest)){
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                }else{
                    response.headers().set(CONNECTION,KEEP_ALIVE);
                    ctx.write(response);
                }
                ctx.flush();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
