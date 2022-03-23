package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.SysRoleMapper;
import com.cap.datareporting.entity.SysRole;
import com.cap.datareporting.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 21:22
 **/
@Service
public class RoleServiceImp implements RoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;


    @Override
    public SysRole selectByPrimaryKey(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }
}
