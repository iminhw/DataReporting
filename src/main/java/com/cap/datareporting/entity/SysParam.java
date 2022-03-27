package com.cap.datareporting.entity;

import java.io.Serializable;
import java.util.Date;

public class SysParam implements Serializable {
    private Long id;

    private Date createDate;

    private String name;

    private String remark;

    private Byte status;

    private Date updateDate;

    private Long createBy;

    private Long updateBy;

    private String dataType;

    private String pid;

    private String title;

    private String value;

    private static final long serialVersionUID = 1L;

    public SysParam(Long id, Date createDate, String name, String remark, Byte status, Date updateDate, Long createBy, Long updateBy, String dataType, String pid, String title, String value) {
        this.id = id;
        this.createDate = createDate;
        this.name = name;
        this.remark = remark;
        this.status = status;
        this.updateDate = updateDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.dataType = dataType;
        this.pid = pid;
        this.title = title;
        this.value = value;
    }

    public SysParam() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}