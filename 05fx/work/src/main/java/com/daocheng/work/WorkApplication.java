package com.daocheng.work;

import com.daocheng.work.service.impl.School;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
		School school = new School();
		school.ding();
	}
}
