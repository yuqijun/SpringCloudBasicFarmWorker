package com.dijiang.staff.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dijiang.common.entity.ResponseResult;
import com.dijiang.common.entity.User;
import com.dijiang.staff.service.SentinelTestService;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/9 18:03
 */
@Service("SentinelTestServiceImpl")
@Slf4j
public class SentinelTestServiceImpl implements SentinelTestService {

    @SentinelResource(value = "sentinel-current-limit",fallback = "fallBack")
    @Override
    public ResponseResult getUser() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("停顿异常.................");
        }

        User  user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setId(123);
        user.setEnable(0);
        user.setUserId(123);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setLastLoginTime(new Date());
        user.setLocked(0);
        return new ResponseResult(200,"访问成功...",user);
    }

    public ResponseResult handleBlock( Exception ex){
        log.info("异常信息-----"+ex);
        return new ResponseResult("服务限流.....");
    }

    public ResponseResult fallBack(Integer id, Exception e){
        return  new ResponseResult("服务降级...");
    }
}
