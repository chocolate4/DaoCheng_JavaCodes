package com.daocheng.other.atomic;

/**
 * 正常计数
 */
public class Count {
    private int num = 0;

    public int add() {
        return num++;
    }

    public int getNum() {
        return num;
    }
}
