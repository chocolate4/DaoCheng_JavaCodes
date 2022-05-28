package com.daocheng.work02;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用LockSupport 自线程执行是暂停主线程，自线程执行完毕放开主线程
 */
public class main04 {
    public void weekup(){
        LockSupport.unpark(thread);
    }
    static Thread thread;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        main04 main04 = new main04();
        thread = Thread.currentThread();
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
                main04.weekup();
            }
        });
        t1.start();
        LockSupport.park();
        System.out.println("主线程结束");
    }
}
