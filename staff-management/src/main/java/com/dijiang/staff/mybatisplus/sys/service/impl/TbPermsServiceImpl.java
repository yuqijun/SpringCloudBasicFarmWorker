package com.dijiang.staff.mybatisplus.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dijiang.staff.mybatisplus.sys.entity.TbPerms;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.dijiang.staff.mybatisplus.sys.entity.TbRolePerms;
import com.dijiang.staff.mybatisplus.sys.mapper.TbPermsMapper;
import com.dijiang.staff.mybatisplus.sys.service.ITbPermsService;
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
@Service("TbPermsServiceImpl")
public class TbPermsServiceImpl extends ServiceImpl<TbPermsMapper, TbPerms> implements ITbPermsService {

    @Autowired
    @Qualifier("TbPermsMapper")
    private TbPermsMapper tbPermsMapper;
    @Override
    public List<TbPerms> allPerms(List<TbRolePerms> tbRolePermsList) {
        return tbPermsMapper.allPerms(tbRolePermsList);
    }
}
