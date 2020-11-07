package com.dijiang.staff.mybatisplus.sys.mapper;

import com.dijiang.staff.mybatisplus.sys.entity.TbPerms;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dijiang.staff.mybatisplus.sys.entity.TbRolePerms;
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
@Repository("TbPermsMapper")
public interface TbPermsMapper extends BaseMapper<TbPerms> {

    @Select("select * from tb_perms tp  where  tp.id  IN <foreach collection=\"permsIdList\" item=\"permsId\" index=\"index\" open=\"(\" close=\")\" separator=\",\"> #{permsId}  </foreach>")
    List<TbPerms> allPerms(@Param("permsIdList") List<TbRolePerms> tbRolePermsList);
}
