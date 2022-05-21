package com.daocheng.week03.other;

import java.io.IOException;

/**
 * runner主方法
 */
public class RunnerMain {
    public static void main(String[] args) throws IOException {

//        Runner1 runner1 = new Runner1();
//        Thread thread1 = new Thread(runner1);

        Runner2 runner2 = new Runner2();
        Thread thread2 = new Thread(runner2);

//        thread1.start();
        thread2.start();

//        thread2.interrupt();  // i = true 中断线程，给予中断标记

        System.out.println("1："+Thread.activeCount());

        Thread.currentThread().getThreadGroup().list();
        System.out.println("2："+Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
        Thread.currentThread().getThreadGroup().getParent().list();


    }
}
