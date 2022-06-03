package com.daocheng.work.service.impl;

import com.daocheng.work.pojo.Klass;
import com.daocheng.work.pojo.Student;
import com.daocheng.work.service.ISchool;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School implements ISchool {

    @Autowired
    Klass klass;

    @Autowired
    Student student;

    @Override
    public void ding() {
        System.out.println(klass);
        System.out.println(student);
    }
}
