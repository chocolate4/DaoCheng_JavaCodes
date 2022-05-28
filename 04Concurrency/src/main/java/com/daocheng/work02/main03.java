package com.daocheng.work02;

/**
 * 创建外部静态变量flag控制  要是用volatile关键字，否则主线程不能及时获取已经变化的flag
 */
public class main03 {
    static volatile boolean flag = false;
    public static void main(String[] args) {
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
                flag = true;
            }
        });
        t1.start();
        while (true){
            if(flag == true){
                break;
            }
        }
        System.out.println("主线程结束");
    }
}
