package com.daocheng.work.java8;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.List;

public class GuavaDemo {

    static EventBus bus = new EventBus();
    static {
        bus.register(new GuavaDemo());
        bus.register(new EventBusTest());
    }

    @SneakyThrows
    public static void main(String[] args) {

        List<String> lists = testString();

        List<Integer> list = testList();

        testMap(list);

        testBiMap(list);

        testEventBus();
    }

    private static List<String> testString() {
        List<String> lists = Lists.newArrayList("a", "b", "g", "8", "9");
        //list的元素用逗号拼接起来
        String result = Joiner.on(",").join(lists);
        System.out.println(result);

        String test = "34344,,,34,34,哈哈";
        //字符串用逗号分割为list
        lists = Splitter.on(",").splitToList(test);
        System.out.println(lists);
        return lists;
    }

    private static List<Integer> testList() {
        List<Integer> list = Lists.newArrayList(4,2,3,5,1,2,2,7,6);
        List<List<Integer>> list1 = Lists.partition(list, 3);
        print(list1);
        return list;
    }

    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }

    private static void testMap(List<Integer> list) {
        ArrayListMultimap<Integer, Integer> bMultimap = ArrayListMultimap.create();
        list.forEach(
                a -> bMultimap.put(a,a+1)
        );
        print(bMultimap);
    }

    private static void testBiMap(List<Integer> lists) {
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);

        System.out.println(words.get("Second").intValue());
        System.out.println(words.inverse().get(3));

        ImmutableMap<Integer, String> map1 = Maps.toMap(lists.listIterator(), a -> a + "value");
        print(map1);
    }

    private static void testEventBus(){
        Student student2 = new Student(2, "KK02");
        System.out.println(Thread.currentThread().getName()+" I want " + student2 + " run now.");
        bus.post(new AEvent(student2));
        bus.post(new EventBusTest.T(student2));
    }

    @Data
    @AllArgsConstructor
    public static class AEvent{
        private Student student;
    }

    @Subscribe
    public void handle(AEvent ae){
        System.out.println(Thread.currentThread().getName()+" "+ae.student + " is running.");
    }
}
