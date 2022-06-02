package com.daocheng.work.Pojo;

import com.daocheng.work.service.ISchool;
import org.springframework.beans.factory.annotation.Autowired;

public class School implements ISchool {

    @Autowired(required = true)
    Klass class1;

    @Autowired
    Student student001;

    @Override
    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student001);
    }

}
