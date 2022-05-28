package com.daocheng.work02;

import java.util.concurrent.CountDownLatch;

/**
 * 使用join方法 等待子线程运行结束后 主线程再执行
 */
public class main02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始运行");
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"运行结束");
            }
        });
        t1.start();
        t1.join();
        System.out.println("主线程结束");
    }
}
