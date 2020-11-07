package com.dijiang.staff.testPackage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dijiang.common.util.JsonUtil;
import com.dijiang.staff.StaffManagementApplication;
import com.dijiang.staff.mybatisplus.sys.entity.TbFile;
import com.dijiang.staff.mybatisplus.sys.entity.TbStaff;
import com.dijiang.staff.mybatisplus.sys.service.impl.TbFileServiceImpl;
import com.dijiang.staff.mybatisplus.sys.service.impl.TbStaffServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes =  StaffManagementApplication.class)
public class TbFileTest {

    @Autowired
    private TbFileServiceImpl tbFileService;

    @Autowired
    private TbStaffServiceImpl tbStaffService;
    @Test
    public void all(){
        Integer pageNo = 1;
        Integer pageSize = 15;
        IPage<TbFile> page = new Page<>(pageNo,pageSize);
        LambdaQueryWrapper<TbFile> lambdaQuery = new LambdaQueryWrapper<>();
        lambdaQuery.eq(TbFile::getDeptId,4);
        IPage<TbFile> t  = tbFileService.page(page,lambdaQuery);
        log.info("list.size()----"+t.getSize());
        t.setTotal(t.getRecords().size());
        log.info("分页十条"+JsonUtil.toJson(tbFileService.page(page,lambdaQuery)));
    }

    @Test
    public void save(){
        BCryptPasswordEncoder  bCryptPasswordEncoder = new BCryptPasswordEncoder();
        TbStaff tbStaff = new TbStaff();
        tbStaff.setAccount("yqj123456");
        tbStaff.setBirth("1111");
        tbStaff.setCapacity(4654564646l);
        tbStaff.setEmail("86488165458@qq.com");
        tbStaff.setId(61);
        tbStaff.setGender(0);
        tbStaff.setName("yqj");
        tbStaff.setPassword(bCryptPasswordEncoder.encode("123456"));
        tbStaff.setRole("admin");
        tbStaff.setPhone("15079892904");
        tbStaffService.save(tbStaff);
    }
}
