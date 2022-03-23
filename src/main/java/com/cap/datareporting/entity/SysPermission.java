package com.cap.datareporting.entity;

import java.io.Serializable;

public class SysPermission implements Serializable {
    private Integer id;

    private String permission;

    private String name;

    private String comments;

    private static final long serialVersionUID = 1L;

    public SysPermission(Integer id, String permission, String name, String comments) {
        this.id = id;
        this.permission = permission;
        this.name = name;
        this.comments = comments;
    }

    public SysPermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}