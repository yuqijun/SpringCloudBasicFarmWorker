package com.dijiang.staff.mybatisplus.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dijiang.staff.mybatisplus.sys.entity.TbStaff;
import com.dijiang.staff.mybatisplus.sys.mapper.TbStaffMapper;
import com.dijiang.staff.mybatisplus.sys.service.ITbStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
@Service("TbStaffServiceImpl")
public class TbStaffServiceImpl extends ServiceImpl<TbStaffMapper, TbStaff> implements ITbStaffService {

    @Autowired
    @Qualifier("TbStaffMapper")
    private TbStaffMapper tbStaffMapper;
    @Override
    public TbStaff getStaff(String name) {
        LambdaQueryWrapper<TbStaff> lambdaQuery = new LambdaQueryWrapper<>();
        lambdaQuery.eq(TbStaff::getName,name);
        return tbStaffMapper.selectOne(lambdaQuery);
    }
}
