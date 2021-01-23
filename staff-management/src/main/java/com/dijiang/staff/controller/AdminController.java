package com.dijiang.staff.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import com.dijiang.common.controller.BaseController;
import com.dijiang.common.entity.ExportTask;
import com.dijiang.common.entity.User;
import com.dijiang.common.util.MathUtil;
import com.dijiang.staff.exception.BusinessException;
import com.dijiang.staff.exception.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/6 17:49
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController extends BaseController {

    @RequestMapping("/")
    public String index (){
        return " hi  admin";
    }


    @RequestMapping("/home")
    public String home (){
        return " hi  admin home";
    }

    @GetMapping("/homeless")
    public ResultBody exceptionTest(){

        int i = 0;

        if(i == 0) {
            throw new BusinessException("业务发生异常...........");
        }
        ResultBody rb = new ResultBody();
        rb.setCode("200");
        rb.setMessage("访问成功............");

        return rb;
    }

}
