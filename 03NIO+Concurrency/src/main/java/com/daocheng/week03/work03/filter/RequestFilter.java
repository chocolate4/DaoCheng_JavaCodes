package com.daocheng.week03.work03.filter;

import io.netty.handler.codec.http.FullHttpRequest;

public class RequestFilter implements HttpRequestFilter{

    @Override
    public void filter(FullHttpRequest fullRequest) {
        fullRequest.headers().set("daocheng","zhang");
    }
}
