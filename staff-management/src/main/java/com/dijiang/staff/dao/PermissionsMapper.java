package com.dijiang.staff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dijiang.common.entity.Permissions;
import com.dijiang.common.entity.dto.PermissionsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
public interface PermissionsMapper extends BaseMapper<Permissions> {

    @Select("<script> select tp.id , tp.permission_id,tp.permission_name,tp.permission_desc,tp.url,tp.create_time,tp.update_time from tb_role_permission trp\n" +
            "LEFT JOIN tb_permissions tp  ON trp.permission_id =  tp.permission_id  where trp.role_id = #{roleId} </script>")
    public List<PermissionsDto> selectByRoleId(@Param("roleId") int roleId);
}
