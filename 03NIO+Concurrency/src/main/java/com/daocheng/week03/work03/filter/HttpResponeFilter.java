package com.daocheng.week03.work03.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponeFilter {
    void filter(FullHttpResponse response);
}
