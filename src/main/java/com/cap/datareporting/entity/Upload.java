package com.cap.datareporting.entity;

import java.io.Serializable;
import java.util.Date;

public class Upload implements Serializable {
    private Long id;

    private String name;

    private String path;

    private String mime;

    private Long size;

    private String md5;

    private String sha1;

    private Long createBy;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Upload(Long id, String name, String path, String mime, Long size, String md5, String sha1, Long createBy, Date createDate) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.mime = mime;
        this.size = size;
        this.md5 = md5;
        this.sha1 = sha1;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public Upload() {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime == null ? null : mime.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1 == null ? null : sha1.trim();
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}