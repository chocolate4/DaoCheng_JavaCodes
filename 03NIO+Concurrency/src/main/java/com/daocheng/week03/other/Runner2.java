package com.daocheng.week03.other;

/**
 * runner方法2  理解interrupted
 */
public class Runner2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner2运行状态——————————" + i);
        }

        boolean result = Thread.currentThread().isInterrupted(); //只查看线程是否被中断

        boolean result1 = Thread.interrupted(); // 重置状态 查看线程是否为中断状态并清除中断状态

        boolean result3 = Thread.currentThread().isInterrupted();

        System.out.println("Runner2.run result ===>" + result);
        System.out.println("Runner2.run result1 ===>" + result1);
        System.out.println("Runner2.run result3 ===>" + result3);
    }
}
