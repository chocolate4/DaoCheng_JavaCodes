package com.daocheng.week03.other;

import java.util.concurrent.Callable;

/**
 * 创建线程C 带有返回值
 */
public class ThreadC implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程C");
        return "线程C";
    }
}
