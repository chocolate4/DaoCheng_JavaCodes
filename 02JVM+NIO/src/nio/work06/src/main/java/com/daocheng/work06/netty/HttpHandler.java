package com.daocheng.work06.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;

public class HttpHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        FullHttpRequest fullRequest = (FullHttpRequest) msg;
        String uri = fullRequest.uri();
        if(uri.contains("/test")){
            handlerTest(fullRequest,ctx,"hello,kimmking");
        }else{
            handlerTest(fullRequest,ctx,"hello,others");
        }
     }

     private void handlerTest(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx, String body){
         FullHttpResponse response = null;
         try {
             String value = body;  //对接上次作业的httpclient或者okhttp请求另一个url的响应数据

//             response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,)
         }catch (Exception e){
             System.out.println("");
         }
     }
}
