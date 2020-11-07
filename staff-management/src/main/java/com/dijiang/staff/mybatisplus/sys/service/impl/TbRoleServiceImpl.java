package com.dijiang.staff.mybatisplus.sys.service.impl;


import com.dijiang.common.entity.query.UserQuery;
import com.dijiang.staff.mybatisplus.sys.entity.TbRole;
import com.dijiang.staff.mybatisplus.sys.mapper.TbRoleMapper;
import com.dijiang.staff.mybatisplus.sys.service.ITbRoleService;
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
@Service("TbRoleServiceImpl")
public class TbRoleServiceImpl extends ServiceImpl<TbRoleMapper, TbRole> implements ITbRoleService {

    @Autowired
    @Qualifier("TbRoleMapper")
    private TbRoleMapper roleMapper;

    @Override
    public List<TbRole> allRole(UserQuery userQuery) {
        return roleMapper.allRole(userQuery.getId().intValue());
    }
}
