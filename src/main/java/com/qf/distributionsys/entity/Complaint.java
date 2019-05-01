package com.qf.distributionsys.entity;

import java.util.Date;

public class Complaint {
    private Integer id;

    private String complaintText;

    private Integer complaintUid;

    private Integer complaintedUid;

    private Date complaintDate;

    private String complaintImg;

    private Integer complaintFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText == null ? null : complaintText.trim();
    }

    public Integer getComplaintUid() {
        return complaintUid;
    }

    public void setComplaintUid(Integer complaintUid) {
        this.complaintUid = complaintUid;
    }

    public Integer getComplaintedUid() {
        return complaintedUid;
    }

    public void setComplaintedUid(Integer complaintedUid) {
        this.complaintedUid = complaintedUid;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintImg() {
        return complaintImg;
    }

    public void setComplaintImg(String complaintImg) {
        this.complaintImg = complaintImg == null ? null : complaintImg.trim();
    }

    public Integer getComplaintFlag() {
        return complaintFlag;
    }

    public void setComplaintFlag(Integer complaintFlag) {
        this.complaintFlag = complaintFlag;
    }
}