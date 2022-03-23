package com.cap.datareporting.entity;

public class SysUserRole {
    private Integer id;

    private Integer uid;

    private Integer roleid;

    public SysUserRole(Integer id, Integer uid, Integer roleid) {
        this.id = id;
        this.uid = uid;
        this.roleid = roleid;
    }

    public SysUserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}