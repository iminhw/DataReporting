package com.cap.datareporting.service;


import com.cap.datareporting.entity.SysRole;

/**
 * @program: blog01
 * @description:
 * @author: MinHw
 * @create: 2022-03-12 21:14
 **/
public interface SysRoleService {

    /**
     *
     * @param id
     * @return
     */
    SysRole selectByPrimaryKey(Long id);
}
