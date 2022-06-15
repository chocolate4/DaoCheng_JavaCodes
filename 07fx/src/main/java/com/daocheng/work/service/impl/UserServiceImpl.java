package com.daocheng.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daocheng.work.mapper.OrderMapper;
import com.daocheng.work.mapper.UserMapper;
import com.daocheng.work.pojo.Order;
import com.daocheng.work.pojo.User;
import com.daocheng.work.service.OrderService;
import com.daocheng.work.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
