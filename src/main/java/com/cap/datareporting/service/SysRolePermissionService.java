package com.cap.datareporting.service;

import com.cap.datareporting.entity.SysRolePermission;

import java.util.List;

/**
 * @program: blog01
 * @description:
 * @author: MinHw
 * @create: 2022-03-12 21:14
 **/
public interface SysRolePermissionService {

    /**
     *
     * @param roleId
     * @return
     */
    List<SysRolePermission> findRolePermissionByRid(Long roleId);
}
