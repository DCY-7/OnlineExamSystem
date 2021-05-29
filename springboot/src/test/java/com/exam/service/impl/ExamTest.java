package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ExamManage;
import com.exam.entity.Student;
import com.exam.service.ExamManageService;
import com.exam.service.StudentService;
import com.exam.util.ApiResultHandler;
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
public class ExamTest {

    @Autowired
    public ExamManageService service;

    @Test
    public void test01(){
        Page<ExamManage> examManagePage = new Page<>(1,4);
        IPage<ExamManage> res = service.findByName(examManagePage,"%"+"计"+"%");

    }

}
