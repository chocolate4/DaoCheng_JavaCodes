package com.daocheng.work.config;

import com.daocheng.work.Pojo.Klass;
import com.daocheng.work.Pojo.School;
import com.daocheng.work.Pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    public Student student(){
        return new Student();
    }

    @Bean
    public Klass klass(){
        return new Klass();
    }
}
