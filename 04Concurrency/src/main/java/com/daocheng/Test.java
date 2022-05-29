package com.daocheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class Test {

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
		ConcurrentHashMap currentHashMap = new ConcurrentHashMap();
	}

}
