package com.daocheng.work.java8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * lambda表达式测试  使用范形是有优势的
 * @param <T> extends 表明约束 T必须是实现了erializable&Comparable&Collection这三个
 */
public class LambdaDemo <T extends Serializable&Comparable& Collection>{
    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();

        MathOperation op = new MathOperation<Integer>(){
            @Override
            public Integer operation(int a, int b) {
                return 1;
            }
        };

        MathOperation op1 = (a,b) -> 1;

        MathOperation op2 = new MathOperation<Integer>(){
            @Override
            public Integer operation(int a, int b) {
                return a+b;
            }
        };
        //类型声明
        MathOperation add = (int a,int b) -> a + b;

        MathOperation sub = (int a,int b) -> a - b;

        MathOperation mul = (a,b) -> {
            return a*b;
        };

        MathOperation div = (a,b) -> a/b;

        System.out.println("10 + 5 = " + demo.operate(10, 5, add));
        System.out.println("10 - 5 = " + demo.operate(10, 5, sub));
        System.out.println("10 x 5 = " + demo.operate(10, 5, mul));
        System.out.println("10 / 5 = " + demo.operate(10, 5, div));

        System.out.println("10 ^ 5 = " + demo.operate(10,5,(a,b) -> Math.pow(10,5)));

        GreetingService greetingService = message -> System.out.println(message);

        GreetingService greetingService1 = message -> {
            System.out.println(message);
        };

        GreetingService greetingService2 = System.out::println;

        Arrays.asList(1,2,3).forEach(x -> System.out.println(x+3));
        Arrays.asList(1,2,3).forEach( LambdaDemo::println);

        greetingService.sayMessage("kimmking");
        greetingService1.sayMessage("Java");
        greetingService2.sayMessage("CuiCuilaoshi");

    }

    private static void println(int x){
        System.out.println(x+3);
    }

    interface MathOperation<T>{
        T operation(int a, int b); //返回类型+函数名+参数类型的列表
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private <T> T operate(int a, int b, MathOperation<T> mathOperation){
        return mathOperation.operation(a, b);
    }
}
