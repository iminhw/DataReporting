package com.cap.datareporting.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class UReq implements Serializable {
    private Long id;

    private Long uid;

    private Byte type;

    private Byte reqStatus;

    private String zy;

    private String gklb;

    private String remark;

    private String reqRemark;

    private String imegsUrlArr;

    private Byte status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private SysUser sysUser;

    private static final long serialVersionUID = 1L;

    public UReq(Long id, Long uid, Byte type, Byte reqStatus, String zy, String gklb, String remark, String reqRemark, String imegsUrlArr, Byte status, Date createDate, Date updateDate) {
        this.id = id;
        this.uid = uid;
        this.type = type;
        this.reqStatus = reqStatus;
        this.zy = zy;
        this.gklb = gklb;
        this.remark = remark;
        this.reqRemark = reqRemark;
        this.imegsUrlArr = imegsUrlArr;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public UReq() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(Byte reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }

    public String getGklb() {
        return gklb;
    }

    public void setGklb(String gklb) {
        this.gklb = gklb == null ? null : gklb.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getReqRemark() {
        return reqRemark;
    }

    public void setReqRemark(String reqRemark) {
        this.reqRemark = reqRemark == null ? null : reqRemark.trim();
    }

    public String getImegsUrlArr() {
        return imegsUrlArr;
    }

    public void setImegsUrlArr(String imegsUrlArr) {
        this.imegsUrlArr = imegsUrlArr == null ? null : imegsUrlArr.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}