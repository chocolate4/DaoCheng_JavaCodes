package com.daocheng.work.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Aspect
public class Aop1 {

    //切入点
    @Pointcut("execution(public void com.daocheng.work.service.impl.School.ding())")
    //切入点签名
    public void log(){
        System.out.println("ISchool pointCut");
    }

    //前置通知
    @Before("log()")
    public void deBefore() {
        System.out.println("  ========>begin ding...");
    }

    @After("log()")
    public void deAfter(){
        System.out.println("  ========>after ding...");
    }

    @Around("log()")
    public void deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("    ====>around begin ding");
        joinPoint.proceed();
        System.out.println("    ====>around finish ding");
    }

}
