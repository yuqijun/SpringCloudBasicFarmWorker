package com.dijiang.staff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dijiang.common.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}
