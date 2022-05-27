package com.daocheng.other.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 加锁计数
 */
public class SyncCount {
    private int num = 0;

    private Lock lock = new ReentrantLock(true);

    public int add() {
        try {
            lock.lock();
            return num++;
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        return num;
    }
}
