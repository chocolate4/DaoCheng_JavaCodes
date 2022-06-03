package com.daocheng.work;

import com.daocheng.work.pojo.Klass;
import com.daocheng.work.pojo.Student;
import com.daocheng.work.service.impl.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBean {

    @Autowired
    School school;


    @Test
    public void TestSchool(){
        school.ding();
    }
}
