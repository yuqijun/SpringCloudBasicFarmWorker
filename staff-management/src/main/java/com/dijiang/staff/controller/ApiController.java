package com.dijiang.staff.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.dijiang.common.controller.BaseController;
import com.dijiang.common.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/8 17:21
 */

@Slf4j
@RequestMapping("/api")
@RestController
public class ApiController extends BaseController {


    @Value("${timeout}")
    String timeout ;

    @Value("${publicKey}")
    String publicKey ;
    @GetMapping("/apollo-test")
    public ResponseResult apolloTest(){
        Map  map = new HashMap();
        map.put("timeout",timeout);
        map.put("publicKey",publicKey);
        return SuccessResult(map);
    }
}
