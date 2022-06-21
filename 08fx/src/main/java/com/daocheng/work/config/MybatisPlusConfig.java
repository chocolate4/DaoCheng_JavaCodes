package com.daocheng.work.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.daocheng.work.mapper")
public class MybatisPlusConfig {

}
