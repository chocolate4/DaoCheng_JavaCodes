package com.daocheng.week03.work03.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class ResponseFilter implements HttpResponeFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("daocheng","zhang");
    }
}
