package com.daocheng.work.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daocheng.work.mapper.OrderMapper;
import com.daocheng.work.pojo.Order;
import com.daocheng.work.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
