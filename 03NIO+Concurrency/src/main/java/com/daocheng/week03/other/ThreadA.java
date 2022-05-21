package com.daocheng.week03.other;

/**
 * 创建线程A
 */
public class ThreadA extends Thread{
    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}
