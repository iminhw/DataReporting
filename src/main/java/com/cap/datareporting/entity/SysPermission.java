package com.cap.datareporting.entity;

public class SysPermission {
    private Integer id;

    private String permission;

    private String url;

    private String name;

    public SysPermission(Integer id, String permission, String url, String name) {
        this.id = id;
        this.permission = permission;
        this.url = url;
        this.name = name;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}