package com.dijiang.staff.component;

import com.dijiang.common.util.JsonUtil;
import com.dijiang.staff.mybatisplus.sys.entity.TbStaff;
import com.dijiang.staff.mybatisplus.sys.service.impl.TbStaffServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    TbStaffServiceImpl tbStaffService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // 1. 查询用户
        TbStaff userFromDatabase = tbStaffService.getStaff(login);
        if (userFromDatabase == null) {
            //log.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + login + " was not found in db");
            //这里找不到必须抛异常
        }
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole());
        grantedAuthorities.add(grantedAuthority);

        List<String>permission = new ArrayList<>();
        permission.add("USER");
        permission.add("ADMIN");
        String [] permissionList =  new String[permission.size()];
        permission.toArray(permissionList);
        UserDetails userDetails = User.withUsername(login).password(userFromDatabase.getPassword()).authorities(permissionList).build();
        log.info("SERVICE   userDetails"+ JsonUtil.toJson(userDetails));
        return userDetails;
    }
}