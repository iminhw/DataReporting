package com.cap.datareporting.entity;

import java.io.Serializable;

public class SysRolePermission implements Serializable {
    private Integer id;

    private Integer roleid;

    private Integer permissionid;

    private static final long serialVersionUID = 1L;

    public SysRolePermission(Integer id, Integer roleid, Integer permissionid) {
        this.id = id;
        this.roleid = roleid;
        this.permissionid = permissionid;
    }

    public SysRolePermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}