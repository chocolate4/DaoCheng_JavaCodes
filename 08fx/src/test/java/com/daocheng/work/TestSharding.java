package com.daocheng.work;

import com.daocheng.work.mapper.OrderMapper;
import com.daocheng.work.pojo.Order;
import com.daocheng.work.services.impl.OrderServiceImpl;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class TestSharding {

    @Autowired
    OrderServiceImpl service;

    @Autowired
    OrderMapper orderMapper;

    @Test
    @Transactional
    @ShardingTransactionType(TransactionType.XA) //TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    void test() throws ParseException {
        final LinkedList<Order> orders = new LinkedList<>();
        for(int j = 1; j < 100; j++) {
            for(int i = 0; i < 100; i++) {
                Order order = new Order();
                order.setOrderId(370000000L + j*100 + i);
                order.setUserId(370000L + j);
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
        }
        service.saveBatch(orders);
//        service.removeById(3300000000L);
//        service.updateById(order);
    }
}
