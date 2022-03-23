package com.cap.datareporting.entity;

import java.io.Serializable;

public class SysRole implements Serializable {
    private Integer id;

    private String role;

    private String name;

    private String defurl;

    private String comments;

    private static final long serialVersionUID = 1L;

    public SysRole(Integer id, String role, String name, String defurl, String comments) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.defurl = defurl;
        this.comments = comments;
    }

    public SysRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDefurl() {
        return defurl;
    }

    public void setDefurl(String defurl) {
        this.defurl = defurl == null ? null : defurl.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}