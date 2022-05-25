package com.daocheng.other.lock;

import java.util.Currency;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * park interrupt
 */

public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }
        @Override public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park(); //暂停当前线程
                System.out.println("park"+ System.nanoTime()); //t1 third  t2 fifth
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        System.out.println("interrupt"+System.nanoTime());  //first
        t1.interrupt(); //中断 暂定状态
        System.out.println("unpark1"+System.nanoTime()); //second
        LockSupport.unpark(t2);
        System.out.println("unpark2"+System.nanoTime()); //forth
        t1.join();
        t2.join();
    }
}
