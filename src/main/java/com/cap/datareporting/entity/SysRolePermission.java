package com.cap.datareporting.entity;

import java.io.Serializable;

public class SysRolePermission implements Serializable {
    private Long roleId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;

    public SysRolePermission(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public SysRolePermission() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}