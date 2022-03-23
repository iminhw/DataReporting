package com.cap.datareporting.service;


import com.cap.datareporting.entity.SysPermission;

/**
 * @program: blog01
 * @description:
 * @author: MinHw
 * @create: 2022-03-12 21:14
 **/
public interface SysPermissionService {

//    List<Permission> find

    SysPermission findPermissionByid(Integer id);
}
