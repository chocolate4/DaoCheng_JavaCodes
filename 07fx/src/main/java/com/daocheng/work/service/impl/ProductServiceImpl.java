package com.daocheng.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daocheng.work.mapper.OrderMapper;
import com.daocheng.work.mapper.ProductMapper;
import com.daocheng.work.pojo.Order;
import com.daocheng.work.pojo.Product;
import com.daocheng.work.service.OrderService;
import com.daocheng.work.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
