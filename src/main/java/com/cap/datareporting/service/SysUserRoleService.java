package com.cap.datareporting.service;

import com.cap.datareporting.entity.SysUserRole;

import java.util.List;

/**
 * @program: blog01
 * @description:
 * @author: MinHw
 * @create: 2022-03-12 21:14
 **/
public interface SysUserRoleService {

    /**
     *
     * @param uid
     * @return
     */
    List<SysUserRole> findUserRoleByUid(Long uid);

    /**
     *
     * @param sysUserRole
     * @return
     */
    int addUserRole(SysUserRole sysUserRole);

}
