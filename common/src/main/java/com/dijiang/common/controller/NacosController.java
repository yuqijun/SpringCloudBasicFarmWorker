package com.dijiang.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/4 16:13
 */
@RequestMapping("/nacos")
@RestController
public class NacosController {
    @RequestMapping(value = "/nacos")
    public String nacos(){
        System.err.println("进入  /nacos/nacos");
        return "FeginClientNacosSuccess";
    }
}
