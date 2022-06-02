package com.daocheng.work;

import com.daocheng.work.Pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class TestBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void TestSchool(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            if(name.equals("klass")) {
                System.out.println(name);
            }
        }
    }
}
