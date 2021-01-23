package com.dijiang.staff.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dijiang.common.entity.ResponseResult;
import com.dijiang.common.entity.User;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/9 18:01
 */
public interface SentinelTestService {

    ResponseResult getUser();

}
