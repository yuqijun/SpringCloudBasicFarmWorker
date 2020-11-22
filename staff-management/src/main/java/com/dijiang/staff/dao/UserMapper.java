package com.dijiang.staff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dijiang.common.entity.User;
import com.dijiang.common.entity.dto.UserDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("<script>  select  tu.id AS id ,tu.password,tu.user_id, tu.username AS username ,tud.user_expatriate_status ,tud.nick_name,tud.user_name, tud.phone,tud.email,tud.address,tud.gender,tud.birthday,\n" +
            "tud.nation, tud.user_state,tud.id_no,tud.permanent_address,tud.salary,tud.work_address, tu.create_time,tu.update_time from tb_user tu\n" +
            "LEFT JOIN  tb_user_detail  tud ON tu.id = tud.user_id where username = #{username} </script>")
    @Results({
            @Result(column = "user_id",property = "roleList",many = @Many(
                    select = "com.dijiang.staff.dao.RoleMapper.selectByUserId"
            )),
            @Result(column = "user_id",property = "userId")
    })
    public UserDto selectUserInfo(@Param("username") String username);
}
