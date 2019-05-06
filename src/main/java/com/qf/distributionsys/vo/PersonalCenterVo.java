package com.qf.distributionsys.vo;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
public class PersonalCenterVo {
    private Integer id;
    private String username;
    private String punishname;
    private Integer award;
    private Integer punish;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPunishname() {
        return punishname;
    }

    public void setPunishname(String punishname) {
        this.punishname = punishname;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public Integer getPunish() {
        return punish;
    }

    public void setPunish(Integer punish) {
        this.punish = punish;
    }
}
