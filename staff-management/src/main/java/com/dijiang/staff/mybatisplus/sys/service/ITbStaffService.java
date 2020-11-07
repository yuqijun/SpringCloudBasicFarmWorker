package com.dijiang.staff.mybatisplus.sys.service;

import com.dijiang.staff.mybatisplus.sys.entity.TbStaff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
public interface ITbStaffService extends IService<TbStaff> {
    //根据用户账号查询用户
    TbStaff getStaff(String account);
}
