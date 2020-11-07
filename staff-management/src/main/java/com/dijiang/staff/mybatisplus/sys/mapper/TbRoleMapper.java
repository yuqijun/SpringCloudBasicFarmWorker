package com.dijiang.staff.mybatisplus.sys.mapper;

import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
@Repository("TbRoleMapper")
public interface TbRoleMapper extends BaseMapper<TbRole> {
    @Select("select role.id , role.`name` , role.descr  from tb_role role  LEFT JOIN staff_and_role sar  on role.id = sar.role_id where sar.staff_id =#{userId}")
    List<TbRole> allRole(@Param("userId") int userId);
}
