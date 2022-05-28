package com.daocheng.work02;

import org.springframework.ui.context.Theme;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 让子线程 先于 主线程中的方法获取同一个锁
 */
public class main05 {

    static main05 main05 = new main05();
    public void tool(){
        synchronized (main05){

        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        com.daocheng.work02.main05 main05 = new main05();
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (com.daocheng.work02.main05.main05) {
                    System.out.println(Thread.currentThread().getName() + "开始运行");
                    for (int j = 0; j < 100; j++) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "运行结束");
                }
            }
        });
        t1.start();
        Thread.sleep(10);
        main05.tool();
        System.out.println("主线程结束");
    }
}
