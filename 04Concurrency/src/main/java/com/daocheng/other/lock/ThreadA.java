package com.daocheng.other.lock;

/**
 * 死锁案例
 */
public class ThreadA extends Thread{
    private Count3 count3;

    public ThreadA(Count3 count3) {
        this.count3 = count3;
    }

    public void run() {
        count3.add();
    }
}
