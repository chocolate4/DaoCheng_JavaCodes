package com.daocheng.work;

import com.daocheng.work.pojo.Order;
import com.daocheng.work.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
public class Work02 {

    @Autowired
    OrderServiceImpl orderService;

    @Test
    //花费:935317毫秒
    public void insertOneByOne() throws ParseException {
        ArrayList<Order> orders = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            Order order = new Order();
            order.setOrderId(1100000000L+i);
            order.setUserId(110000L+i);
            order.setOrderStatus("已下单");
            order.setProductCount(1);
            order.setPrice(100.0);
            order.setOrderCreateTime(1655136000L);
            order.setOrderFinishTime(1655136000L);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
            Date createTime = simpleDateFormat1.parse("2022-06-15 00:00:00");
            order.setCreateTime(createTime);
            order.setUpdateTime(createTime);
            orders.add(order);
        }

//        System.out.println();
        Long startTime = System.currentTimeMillis();
        orders.stream().forEach(o -> orderService.save(o));
        Long endTime = System.currentTimeMillis();

        System.out.println("花费:"+ (endTime - startTime) + "毫秒");

        //速度太慢不予考虑

    }

    @Test
    //花费:630876毫秒
    public void insertByBatch() throws ParseException {
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Order order = new Order();
            order.setOrderId(3300000000L + i);
            order.setUserId(330000L + i);
            order.setOrderStatus("已下单");
            order.setProductCount(1);
            order.setPrice(100.0);
            order.setOrderCreateTime(1655136000L);
            order.setOrderFinishTime(1655136000L);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
            Date createTime = simpleDateFormat1.parse("2022-06-15 00:00:00");
            order.setCreateTime(createTime);
            order.setUpdateTime(createTime);
            orders.add(order);
        }
        Long startTime = System.currentTimeMillis();
        orderService.saveBatch(orders,1000);
        Long endTime = System.currentTimeMillis();
        System.out.println("花费:"+ (endTime - startTime) + "毫秒");
    }
}
