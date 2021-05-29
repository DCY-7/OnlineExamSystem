package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dengchenyang
 * @version 1.0
 * @description: TODO
 * @date 2021/5/16 12:08 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    public StudentService studentService;

    @Test
    public void test01(){
        Page<Student> studentPage = new Page<>(1,6);
        IPage<Student> students = studentService.findByName(studentPage,"%大%");
        System.out.println(students);
    }

}
