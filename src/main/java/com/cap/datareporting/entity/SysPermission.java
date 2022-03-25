package com.cap.datareporting.entity;

import java.io.Serializable;
import java.util.Date;

public class SysPermission implements Serializable {
    private Long id;

    private String permission;

    private String name;

    private String remark;

    private Date createDate;

    private Date updateDate;

    private Long createBy;

    private Long updateBy;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public SysPermission(Long id, String permission, String name, String remark, Date createDate, Date updateDate, Long createBy, Long updateBy, Byte status) {
        this.id = id;
        this.permission = permission;
        this.name = name;
        this.remark = remark;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.status = status;
    }

    public SysPermission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}