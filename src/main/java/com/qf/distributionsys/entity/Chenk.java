package com.qf.distributionsys.entity;

public class Chenk {
    private Integer id;

    private Integer checkuid;

    private Integer uid;

    private String behindimg;

    private String frontimg;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckuid() {
        return checkuid;
    }

    public void setCheckuid(Integer checkuid) {
        this.checkuid = checkuid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBehindimg() {
        return behindimg;
    }

    public void setBehindimg(String behindimg) {
        this.behindimg = behindimg == null ? null : behindimg.trim();
    }

    public String getFrontimg() {
        return frontimg;
    }

    public void setFrontimg(String frontimg) {
        this.frontimg = frontimg == null ? null : frontimg.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}