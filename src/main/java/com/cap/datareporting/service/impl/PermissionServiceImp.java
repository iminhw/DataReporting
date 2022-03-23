package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.SysPermissionMapper;
import com.cap.datareporting.entity.SysPermission;
import com.cap.datareporting.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 21:21
 **/
@Service
public class PermissionServiceImp implements PermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public SysPermission findPermissionByid(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }
}
