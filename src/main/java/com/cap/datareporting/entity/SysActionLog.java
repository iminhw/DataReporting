package com.cap.datareporting.entity;

import java.io.Serializable;
import java.util.Date;

public class SysActionLog implements Serializable {
    private Long id;

    private String name;

    private Byte type;

    private String ipaddr;

    private String clazz;

    private String method;

    private String model;

    private Long recordId;

    private Date createDate;

    private String operName;

    private Long operBy;

    private String message;

    private static final long serialVersionUID = 1L;

    public SysActionLog(Long id, String name, Byte type, String ipaddr, String clazz, String method, String model, Long recordId, Date createDate, String operName, Long operBy, String message) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ipaddr = ipaddr;
        this.clazz = clazz;
        this.method = method;
        this.model = model;
        this.recordId = recordId;
        this.createDate = createDate;
        this.operName = operName;
        this.operBy = operBy;
        this.message = message;
    }

    public SysActionLog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public Long getOperBy() {
        return operBy;
    }

    public void setOperBy(Long operBy) {
        this.operBy = operBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}