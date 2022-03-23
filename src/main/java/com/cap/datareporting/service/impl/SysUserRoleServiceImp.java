package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.SysUserRoleMapper;
import com.cap.datareporting.entity.SysUserRole;
import com.cap.datareporting.entity.SysUserRoleExample;
import com.cap.datareporting.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 21:23
 **/
@Service
public class SysUserRoleServiceImp implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysUserRole> findUserRoleByUid(Integer uid) {
        SysUserRoleExample example = new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        return sysUserRoleMapper.selectByExample(example);
    }

    @Override
    public int addUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insert(sysUserRole);
    }
}
