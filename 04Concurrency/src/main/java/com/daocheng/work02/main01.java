package com.daocheng.work02;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 等待自线程结束后主线程再执行
 */
public class main01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
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
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
        }).start();
        countDownLatch.await();
        System.out.println("主线程结束");
    }
}
