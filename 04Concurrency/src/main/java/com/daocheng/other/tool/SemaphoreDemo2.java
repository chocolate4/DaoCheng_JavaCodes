package com.daocheng.other.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 许可数
 */
public class SemaphoreDemo2 {
    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    //赋予semaphore共5个许可，每次执行消耗5个许可，默认是1个
                    semaphore.acquire(5); // 获取全部许可，退化成串行执行
                    test(threadNum);
                    semaphore.release(5); // 释放多个许可
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        System.out.println("id:"+threadNum+","+Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
