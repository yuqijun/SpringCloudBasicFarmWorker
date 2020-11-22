package com.dijiang.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dijiang.common.entity.UserRole;
import com.dijiang.staff.dao.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户对应角色表 服务实现类
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IService<UserRole> {

}
