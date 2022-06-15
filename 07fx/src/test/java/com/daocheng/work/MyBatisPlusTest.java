package com.daocheng.work;

import com.daocheng.work.mapper.OrderMapper;
import com.daocheng.work.pojo.Order;
import com.daocheng.work.service.impl.OrderServiceImpl;
import com.daocheng.work.service.impl.ProductServiceImpl;
import com.daocheng.work.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void test1(){
        long count = orderService.count();
        System.out.println("t_order:" + count);

        long count1 = userService.count();
        System.out.println("t_user" + count1);

        long count2 = productService.count();
        System.out.println("t_product" + count2);
    }

    @Test
    public void insertOrder() throws ParseException {
        Order order = new Order();
        order.setOrderId(1000000000L);
        order.setUserId(100000L);
        order.setOrderStatus("已下单");
        order.setProductCount(1);
        order.setPrice(100.0);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
//        String format = simpleDateFormat.format(1655136000L);
        order.setOrderCreateTime(1655136000L);
        order.setOrderFinishTime(1655136000L);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date createTime = simpleDateFormat1.parse("2022-06-15 00:00:00");
        order.setCreateTime(createTime);
        order.setUpdateTime(createTime);
        orderMapper.insert(order);
    }

}
