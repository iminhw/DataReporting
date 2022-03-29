package com.cap.datareporting.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private String picture;

    private Byte sex;

    private String ksh;

    private String abbreviation;

    private String email;

    private String phone;

    private String remark;

    private Date createDate;

    private Date updateDate;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public SysUser(Long id, String username, String nickname, String password, String salt, String picture, Byte sex, String ksh, String abbreviation, String email, String phone, String remark, Date createDate, Date updateDate, Byte status) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.salt = salt;
        this.picture = picture;
        this.sex = sex;
        this.ksh = ksh;
        this.abbreviation = abbreviation;
        this.email = email;
        this.phone = phone;
        this.remark = remark;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public SysUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}