package com.daocheng.work.config;

import com.daocheng.work.pojo.Klass;
import com.daocheng.work.pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigBean {

    @Bean(name="student")
    public Student getStudent(){
        Student student = new Student();
        student.setBeanName("student");
        student.setId(001);
        student.setName("ZDC");
        student.setApplicationContext(null);
        return student;
    }

    @Bean(name="klass")
    public Klass getKlass(){
        Klass klass = new Klass();
        List<Student> students = new ArrayList<Student>();
        students.add(new ConfigBean().getStudent());
        klass.setStudents(students);
        return klass;
    }

}
