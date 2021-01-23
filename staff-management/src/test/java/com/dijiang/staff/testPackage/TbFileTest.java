//package com.dijiang.staff.testPackage;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.dijiang.common.entity.ReExportRecord;
//import com.dijiang.staff.StaffManagementApplication;
//import com.dijiang.staff.dao.RabbitQueueInfoMapper;
//import com.dijiang.staff.dao.ReExportRecordMapper;
//import com.dijiang.staff.service.impl.RabbitQueueInfoServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes =  StaffManagementApplication.class)
//public class TbFileTest {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private ReExportRecordMapper mapper;
//
//    @Autowired
//    private RabbitQueueInfoServiceImpl rabbitQueueInfoService;
//
//
//    @Test
//    public void secreat(){
//        String password = "123456";
//        String secreat =  passwordEncoder.encode(password);
//        log.info("加密后的密码--："+secreat);
//    }
//
//
//    @Test
//    public void mai(){
//
//        IPage<ReExportRecord> iPage = new Page<>(1,5);
//        LambdaQueryWrapper<ReExportRecord> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        System.err.println("即将输出-----------------------------------");
//        System.err.println(mapper.selectPage(iPage,lambdaQueryWrapper));
//    }
//
//
//
//    @Test
//    public void mai2(){
//        log.info("返回值  - - - - -  {}",rabbitQueueInfoService.selectListByApplicationId("100100"));
//    }
//
//}
