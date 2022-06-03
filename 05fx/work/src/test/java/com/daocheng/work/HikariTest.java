package com.daocheng.work;

import com.daocheng.work.dao.UserMapper;
import com.daocheng.work.pojo.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HikariTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        List<TUser> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
