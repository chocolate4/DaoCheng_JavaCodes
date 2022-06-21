package com.daocheng.work;

import com.daocheng.work.mapper.OrderMapper;
import com.daocheng.work.pojo.Order;
import com.daocheng.work.services.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestSharding {

    @Autowired
    OrderServiceImpl service;

    @Autowired
    OrderMapper orderMapper;

    @Test
    void test() throws ParseException {
        Order order = new Order();
        order.setOrderId(3300000009L);
        order.setUserId(330005L);
        order.setOrderStatus("已下单");
        order.setProductCount(1);
        order.setPrice(100.0);
        order.setOrderCreateTime(1655136000L);
        order.setOrderFinishTime(1655136000L);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date createTime = simpleDateFormat1.parse("2022-06-15 00:00:00");
        order.setCreateTime(createTime);
        order.setUpdateTime(createTime);
        orderMapper.insert(order);
//        service.save(order);
//        List<Order> orders = orderMapper.selectList(null);
//        System.out.println(orders.size());
//        service.removeById(3300000000L);
//        service.updateById(order);
    }
}
