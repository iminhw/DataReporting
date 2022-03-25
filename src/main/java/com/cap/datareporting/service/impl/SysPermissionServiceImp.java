package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.SysPermissionMapper;
import com.cap.datareporting.entity.SysPermission;
import com.cap.datareporting.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 21:21
 **/
@Service
public class SysPermissionServiceImp implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public SysPermission findPermissionByid(Long id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }
}
