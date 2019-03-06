package com.ecjtu.order.bean;

import java.util.Date;

/**
 * Desc: 订单实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:10
 */
public class Orders
{
    /**
     * id
     */
    private Integer orderId;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 下单时间
     */
    private Date orderDate;

    /**
     * 送达时间
     */
    private Date endDate;

    /**
     * 配送地址
     */
    private String sendAddr;

    /**
     * 收货人
     */
    private String orderName;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr == null ? null : sendAddr.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString()
    {
        return "Orders{" +
            "orderId=" + orderId +
            ", orderStatus=" + orderStatus +
            ", userId=" + userId +
            ", orderDate=" + orderDate +
            ", endDate=" + endDate +
            ", sendAddr='" + sendAddr + '\'' +
            ", orderName='" + orderName + '\'' +
            '}';
    }
}
