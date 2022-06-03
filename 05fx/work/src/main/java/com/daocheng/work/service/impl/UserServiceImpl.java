package com.daocheng.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daocheng.work.dao.UserMapper;
import com.daocheng.work.pojo.TUser;
import com.daocheng.work.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements UserService {
}
