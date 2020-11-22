package com.dijiang.staff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dijiang.common.entity.Role;
import com.dijiang.common.entity.dto.RoleDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户权限角色表 Mapper 接口
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("<script> select tr.id,tr.role_id,tr.`name`,tr.role_desc,tr.create_time,tr.update_time  from tb_user_role  tur\n" +
            "left JOIN tb_role tr  ON tur.role_id  = tr.role_id  where tur.user_id = #{userId} </script>")
    @Results({
            @Result(column = "role_id",property = "permissionsList",many = @Many(
                    select = "com.dijiang.staff.dao.PermissionsMapper.selectByRoleId"
            )),
            @Result(column = "role_id",property = "roleId")
    })
    public List<RoleDto>selectByUserId(@Param("userId") int userId);
}
