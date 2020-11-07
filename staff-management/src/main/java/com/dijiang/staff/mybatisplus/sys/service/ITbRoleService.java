package com.dijiang.staff.mybatisplus.sys.service;

import com.dijiang.common.entity.query.UserQuery;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
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
public interface ITbRoleService extends IService<TbRole> {

    List<TbRole> allRole(UserQuery userQuery);

}
