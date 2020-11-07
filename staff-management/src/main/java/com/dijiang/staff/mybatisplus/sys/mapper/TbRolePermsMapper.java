package com.dijiang.staff.mybatisplus.sys.mapper;

import com.dijiang.staff.mybatisplus.sys.entity.TbPerms;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.dijiang.staff.mybatisplus.sys.entity.TbRolePerms;
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
@Repository("TbRolePermsMapper")
public interface TbRolePermsMapper extends BaseMapper<TbRolePerms> {


    //传一个角色集合
    @Select("select trp.p_id from tb_role_perms trp where  trp.r_id in <foreach collection=\"roleList\" item=\"role\" index=\"index\" open=\"(\" close=\")\" separator=\",\"> #{role} </foreach> ")
    List<TbRolePerms> allPerms(@Param("roleList")List<TbRole> tbRoleList);
}
