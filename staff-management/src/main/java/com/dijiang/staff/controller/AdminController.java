package com.dijiang.staff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/6 17:49
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/")
    public String index (){
        return " hi  admin";
    }


    @RequestMapping("/home")
    public String home (){
        return " hi  admin home";
    }
}
