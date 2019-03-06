package com.ecjtu.order.bean;

/**
 * Desc: 餐馆实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:10
 */
public class Restaurant
{

    /**
     * id
     */
    private Integer restaurId;

    /**
     * 名字
     */
    private String restaurName;

    /**
     * 地址
     */
    private String restaurAddress;

    /**
     * 电话
     */
    private String phone;

    /**
     * 送餐范围
     */
    private String restaurRange;

    /**
     * 餐厅描述
     */
    private String restaurDescribe;

    /**
     * 配送费
     */
    private Integer fee;

    /**
     * 图片
     */
    private String restaurPic;

    public Integer getRestaurId() {
        return restaurId;
    }

    public void setRestaurId(Integer restaurId) {
        this.restaurId = restaurId;
    }

    public String getRestaurName() {
        return restaurName;
    }

    public void setRestaurName(String restaurName) {
        this.restaurName = restaurName == null ? null : restaurName.trim();
    }

    public String getRestaurAddress() {
        return restaurAddress;
    }

    public void setRestaurAddress(String restaurAddress) {
        this.restaurAddress = restaurAddress == null ? null : restaurAddress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }


    public String getRestaurRange() {
        return restaurRange;
    }


    public void setRestaurRange(String restaurRange) {
        this.restaurRange = restaurRange == null ? null : restaurRange.trim();
    }


    public String getRestaurDescribe() {
        return restaurDescribe;
    }


    public void setRestaurDescribe(String restaurDescribe) {
        this.restaurDescribe = restaurDescribe == null ? null : restaurDescribe.trim();
    }

    public Integer getFee() {
        return fee;
    }


    public void setFee(Integer fee) {
        this.fee = fee;
    }


    public String getRestaurPic() {
        return restaurPic;
    }

    public void setRestaurPic(String restaurPic) {
        this.restaurPic = restaurPic == null ? null : restaurPic.trim();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
            "restaurId=" + restaurId +
            ", restaurName='" + restaurName + '\'' +
            ", restaurAddress='" + restaurAddress + '\'' +
            ", phone='" + phone + '\'' +
            ", restaurRange='" + restaurRange + '\'' +
            ", restaurDescribe='" + restaurDescribe + '\'' +
            ", fee=" + fee +
            ", restaurPic='" + restaurPic + '\'' +
            '}';
    }
}
