package com.dijiang.staff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dijiang.common.entity.Permissions;
import com.dijiang.common.entity.RabbitQueueInfo;
import com.dijiang.common.entity.dto.PermissionsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户权限表 Mapper 接口
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Mapper
public interface RabbitQueueInfoMapper extends BaseMapper<RabbitQueueInfo> {
}
