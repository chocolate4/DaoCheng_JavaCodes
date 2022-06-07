package com.daocheng.work.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        System.out.println("使用 Java 8: ");
        System.out.println("列表: " +strings);

        long count = strings.stream().filter(e -> e.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        long count1 = strings.stream().filter(e -> e.length() == 3).count();
        System.out.println("长度为3的字符串数量为: " + count);

        List<String> collect = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + collect);

        String collect1 = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + collect1);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        Random random = new Random();

        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("列表: " +integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");

        random.ints().limit(10).sorted().forEach(System.out::println);
        // 并行处理
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量为: " + count);
    }
}
