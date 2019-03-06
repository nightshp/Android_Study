package com.ecjtu.order.bean;

import java.util.Date;

/**
 * Desc: 配送员实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:09
 */
public class Deliver
{

    /**
     * id
     */
    private Integer deliverId;

    /**
     * 名字
     */
    private String deliverName;

    /**
     * 电话
     */
    private String deliverPhone;

    /**
     * 住址
     */
    private String homeAddr;

    /**
     * 入职时间
     */
    private Date employDate;

    /**
     * 服务餐馆
     */
    private Integer restaurId;

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName == null ? null : deliverName.trim();
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone == null ? null : deliverPhone.trim();
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr == null ? null : homeAddr.trim();
    }

    public Date getEmployDate() {
        return employDate;
    }

    public void setEmployDate(Date employDate) {
        this.employDate = employDate;
    }

    public Integer getRestaurId() {
        return restaurId;
    }

    public void setRestaurId(Integer restaurId) {
        this.restaurId = restaurId;
    }

    @Override
    public String toString()
    {
        return "Deliver{" +
            "deliverId=" + deliverId +
            ", deliverName='" + deliverName + '\'' +
            ", deliverPhone='" + deliverPhone + '\'' +
            ", homeAddr='" + homeAddr + '\'' +
            ", employDate=" + employDate +
            ", restaurId=" + restaurId +
            '}';
    }
}
