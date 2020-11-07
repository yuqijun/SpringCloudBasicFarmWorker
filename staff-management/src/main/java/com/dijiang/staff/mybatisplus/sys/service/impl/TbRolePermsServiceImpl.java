package com.dijiang.staff.mybatisplus.sys.service.impl;

import com.dijiang.staff.mybatisplus.sys.entity.TbPerms;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.dijiang.staff.mybatisplus.sys.entity.TbRolePerms;
import com.dijiang.staff.mybatisplus.sys.mapper.TbRolePermsMapper;
import com.dijiang.staff.mybatisplus.sys.service.ITbRolePermsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */

@Service("TbRolePermsServiceImpl")
public class TbRolePermsServiceImpl extends ServiceImpl<TbRolePermsMapper, TbRolePerms> implements ITbRolePermsService {


    @Autowired
    @Qualifier("TbRolePermsMapper")
    private TbRolePermsMapper tbRolePermsMapper;
    @Override
    public List<TbRolePerms> allPerms(List<TbRole> tbRoleList) {
        return tbRolePermsMapper.allPerms(tbRoleList);
    }
}
