package com.cap.datareporting.entity;

public class SysRole {
    private Integer id;

    private String role;

    private String name;

    public SysRole(Integer id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
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
}