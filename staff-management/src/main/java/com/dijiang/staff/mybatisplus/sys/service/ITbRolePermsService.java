package com.dijiang.staff.mybatisplus.sys.service;

import com.dijiang.staff.mybatisplus.sys.entity.TbPerms;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.dijiang.staff.mybatisplus.sys.entity.TbRolePerms;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
public interface ITbRolePermsService extends IService<TbRolePerms> {
    //传一个角色集合
    List<TbRolePerms> allPerms(List<TbRole> tbRoleList);
}
