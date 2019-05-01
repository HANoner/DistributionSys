package com.qf.distributionsys.entity;

import java.util.Date;

public class User {
    private Integer uid;

    private String username;

    private String password;

    private String phone;

    private String wechatid;

    private Integer invitatedcode;

    private Integer invitationcode;

    private Date loginLastDate;

    private Integer level;

    private Integer flag;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechatid() {
        return wechatid;
    }

    public void setWechatid(String wechatid) {
        this.wechatid = wechatid == null ? null : wechatid.trim();
    }

    public Integer getInvitatedcode() {
        return invitatedcode;
    }

    public void setInvitatedcode(Integer invitatedcode) {
        this.invitatedcode = invitatedcode;
    }

    public Integer getInvitationcode() {
        return invitationcode;
    }

    public void setInvitationcode(Integer invitationcode) {
        this.invitationcode = invitationcode;
    }

    public Date getLoginLastDate() {
        return loginLastDate;
    }

    public void setLoginLastDate(Date loginLastDate) {
        this.loginLastDate = loginLastDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}