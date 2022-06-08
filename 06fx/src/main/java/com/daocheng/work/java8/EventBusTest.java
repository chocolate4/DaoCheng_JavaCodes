package com.daocheng.work.java8;

import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;

public class EventBusTest {

    @Data
    @AllArgsConstructor
    public static class T{
        private Student student;
    }

    @Subscribe
    public void handle(T t){
        System.out.println(Thread.currentThread().getName()+" "+t.student + " is running.");
    }
}
