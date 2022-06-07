package com.daocheng.work.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,3,5,1,2,2,7,6);   // Arrays还可以包装stream
        print(list);
        Collections.sort(list);
        print(list);
        Collections.reverse(list);
        print(list);
        Collections.shuffle(list);
        print(list);

        System.out.println(Collections.frequency(list, 2));
        System.out.println(Collections.max(list));

        //填充
        Collections.fill(list,8);
        print(list);

        //单值转list
        list = Collections.singletonList(6);
        print(list);
    }

    private static void print(List<Integer> list){
        List<String> collect = list.stream().map(i -> i.toString()).collect(Collectors.toList());
        Object[] objects = collect.toArray();
        String[] strings = collect.toArray(new String[]{});
        System.out.println(String.join(",",list.stream().map(i -> i.toString()).collect(Collectors.toList()).toArray(new String[]{})));
    }
}
