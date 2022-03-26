package com.cap.datareporting.entity;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class SysDict implements Serializable {
    private Long id;

    private String title;

    private String name;

    private Byte type;

    private String remark;

    private Date createDate;

    private Date updateDate;

    private Long createBy;

    private Long updateBy;

    private Byte status;

    private String value;

    private static final long serialVersionUID = 1L;

    public SysDict(Long id, String title, String name, Byte type, String remark, Date createDate, Date updateDate, Long createBy, Long updateBy, Byte status, String value) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.type = type;
        this.remark = remark;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.status = status;
        this.value = value;
    }

    public SysDict() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}