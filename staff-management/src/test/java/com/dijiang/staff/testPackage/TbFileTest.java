package com.dijiang.staff.testPackage;


import com.dijiang.staff.StaffManagementApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes =  StaffManagementApplication.class)
public class TbFileTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void secreat(){
        String password = "123456";
        String secreat =  passwordEncoder.encode(password);
        log.info("加密后的密码--："+secreat);
    }
}
