package com.dijiang.staff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dijiang.common.entity.RabbitQueueInfo;
import com.dijiang.staff.dao.RabbitQueueInfoMapper;
import com.dijiang.staff.service.IRabbitQueueInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitQueueInfoServiceImpl extends ServiceImpl<RabbitQueueInfoMapper, RabbitQueueInfo> implements IRabbitQueueInfoService {

    @Autowired
    private RabbitQueueInfoMapper mapper;

    public List<RabbitQueueInfo> selectListByApplicationId(String applicationId){
        LambdaQueryWrapper<RabbitQueueInfo> lambda = new LambdaQueryWrapper<>();
        lambda.eq(RabbitQueueInfo::getApplicationId,applicationId);
        return mapper.selectList(lambda);
    }

    public List<RabbitQueueInfo> allList(){
        LambdaQueryWrapper<RabbitQueueInfo> lambda = new LambdaQueryWrapper<>();
        return mapper.selectList(lambda);
    }

}
