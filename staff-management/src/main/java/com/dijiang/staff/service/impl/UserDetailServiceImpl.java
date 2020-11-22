package com.dijiang.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dijiang.common.entity.UserDetail;
import com.dijiang.staff.dao.UserDetailMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户详情表 服务实现类
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IService<UserDetail> {

}
