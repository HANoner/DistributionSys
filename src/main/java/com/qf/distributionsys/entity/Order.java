package com.qf.distributionsys.entity;

public class Order {
    private Integer id;

    private Integer buyuid;

    private Integer saleuid;

    private Integer orderstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyuid() {
        return buyuid;
    }

    public void setBuyuid(Integer buyuid) {
        this.buyuid = buyuid;
    }

    public Integer getSaleuid() {
        return saleuid;
    }

    public void setSaleuid(Integer saleuid) {
        this.saleuid = saleuid;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }
}