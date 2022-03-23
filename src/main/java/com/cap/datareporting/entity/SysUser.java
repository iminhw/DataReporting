package com.cap.datareporting.entity;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String ksh;

    private String email;

    private String phone;

    private String kaoshenhao;

    private String headPicture;

    private String salt;

    private Integer status;

    private String comments;

    private static final long serialVersionUID = 1L;

    public SysUser(Integer id, String name, String username, String password, String ksh, String email, String phone, String kaoshenhao, String headPicture, String salt, Integer status, String comments) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.ksh = ksh;
        this.email = email;
        this.phone = phone;
        this.kaoshenhao = kaoshenhao;
        this.headPicture = headPicture;
        this.salt = salt;
        this.status = status;
        this.comments = comments;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getKaoshenhao() {
        return kaoshenhao;
    }

    public void setKaoshenhao(String kaoshenhao) {
        this.kaoshenhao = kaoshenhao == null ? null : kaoshenhao.trim();
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture == null ? null : headPicture.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}