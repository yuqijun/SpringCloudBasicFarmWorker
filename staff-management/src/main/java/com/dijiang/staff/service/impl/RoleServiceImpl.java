package com.dijiang.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dijiang.common.entity.Role;
import com.dijiang.staff.dao.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限角色表 服务实现类
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IService<Role> {

}
