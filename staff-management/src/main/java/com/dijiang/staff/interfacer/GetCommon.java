package com.dijiang.staff.interfacer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/4 16:19
 */

@FeignClient("common-consumer")
public interface GetCommon {
    @RequestMapping("/nacos/nacos")
    public String nacos();
}
