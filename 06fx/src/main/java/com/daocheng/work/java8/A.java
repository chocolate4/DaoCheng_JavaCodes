package com.daocheng.work.java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class A {
    private int age;

    private String name;

    public void test(){
        log.info("this message is logged by lombok");
        System.out.println(this.toString());
    }
}
