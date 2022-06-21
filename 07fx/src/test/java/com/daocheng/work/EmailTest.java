package com.daocheng.work;

import com.daocheng.work.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailTest {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    OrderServiceImpl orderService;

    @Test
    void contextLoads() throws Exception{
        long count = orderService.count();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("806186987@qq.com");
        message.setText("内容"+ String.valueOf(count));
        message.setSubject("主题");
        message.setTo("806186987@qq.com");
//        message.setCc("抄送人");
//        message.setBcc("密送人");
        javaMailSender.send(message);
    }
}
