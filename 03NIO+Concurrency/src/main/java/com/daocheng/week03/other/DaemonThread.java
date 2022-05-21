package com.daocheng.week03.other;

/**
 * 守护线程
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("当前线程:" + t.getName());
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        thread.setDaemon(true);  //守护线程：主线程完成直接停止掉
        thread.start();
//        Thread.sleep(5500);
    }
}
