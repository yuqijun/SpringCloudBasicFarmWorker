package com.dijiang.staff.mybatisplus.sys.service;

import com.dijiang.staff.mybatisplus.sys.entity.TbPerms;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.dijiang.staff.mybatisplus.sys.entity.TbRolePerms;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
public interface ITbPermsService extends IService<TbPerms> {
    List<TbPerms> allPerms(List<TbRolePerms> tbRolePermsList);
}
