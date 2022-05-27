package com.daocheng.other.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子计数
 */
public class AtomicCount {
    private AtomicInteger num = new AtomicInteger();

    public int add() {
        return num.getAndIncrement();
    }

    public int getNum() {
        return num.get();
    }
}
