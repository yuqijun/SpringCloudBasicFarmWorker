package com.dijiang.staff.component;

import com.dijiang.common.entity.dto.UserDto;
import com.dijiang.common.util.JsonUtil;
import com.dijiang.staff.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/6 22:12
 */
@Slf4j
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        // 1. 查询用户
//        TbStaff userFromDatabase = tbStaffService.getStaff(login);
//        if (userFromDatabase == null) {
//            throw new UsernameNotFoundException("User " + login + " was not found in db");
//            //这里找不到必须抛异常
//        }
//        // 2. 设置角色
//        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole());
//        grantedAuthorities.add(grantedAuthority);
//
//        List<String>permission = new ArrayList<>();
//        permission.add("USER");
//        permission.add("ADMIN");
//        String [] permissionList =  new String[permission.size()];
//        permission.toArray(permissionList);
//        UserDetails userDetails = User.withUsername(login).password(userFromDatabase.getPassword()).authorities(permissionList).build();
//        log.info("SERVICE   userDetails"+ JsonUtil.toJson(userDetails));
//        return userDetails;

        /* 校验用户 */
        UserDto userDto = userMapper.selectUserInfo(login);
        if(null==userDto){
            throw new UsernameNotFoundException("User  "+login+"  not found");
        }

        log.info("验证用户 --userDto："+JsonUtil.toJson(userDto));

        /* 用户权限列表 */
        List<String>permissionList = new ArrayList<>();
        /* 用户角色列表 */
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        userDto.getRoleList().forEach(role ->{
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorities.add(grantedAuthority);
            role.getPermissionsList().forEach( permissions->{permissionList.add(permissions.getPermissionName());});
        });

        String [] permissionArray =  new String[permissionList.size()];
        permissionList.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(login).password(userDto.getPassword()).authorities(permissionArray).build();
        log.info("验证用户 --角色--------------："+JsonUtil.toJson(grantedAuthorities));
        log.info("验证用户 --权限--------------："+JsonUtil.toJson(permissionList));
        log.info("验证用户 -- userDetails"+ JsonUtil.toJson(userDetails));
        return userDetails;
    }
}