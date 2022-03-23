package com.cap.datareporting.service;


import com.cap.datareporting.entity.SysUser;

public interface SysUserService {

    /**
     * 通过username查找用户信息;
     */
    SysUser findByUsername(String username);

    SysUser findById(int id);

    /**
     *
     * @param user
     * @return
     */
    int addUser(SysUser user);

}
