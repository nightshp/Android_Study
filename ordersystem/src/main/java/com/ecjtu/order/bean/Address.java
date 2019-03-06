package com.ecjtu.order.bean;

/**
 * Desc: 地址实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:09
 */
public class Address
{
    /**
     * id
     */
    private Integer addressId;

    /**
     * 收货人姓名
     */
    private String recName;

    /**
     * 所在区
     */
    private String areaAddress;

    /**
     * 详细地址
     */
    private String detaAddress;

    /**
     * 邮编
     */
    private Integer postalcode;

    /**
     * 电话
     */
    private String phone;

    /**
     * 是否为默认地址
     */
    private Integer isdefault;

    /**
     * 用户id
     */
    private Integer userId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName == null ? null : recName.trim();
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress == null ? null : areaAddress.trim();
    }

    public String getDetaAddress() {
        return detaAddress;
    }

    public void setDetaAddress(String detaAddress) {
        this.detaAddress = detaAddress == null ? null : detaAddress.trim();
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
            "addressId=" + addressId +
            ", recName='" + recName + '\'' +
            ", areaAddress='" + areaAddress + '\'' +
            ", detaAddress='" + detaAddress + '\'' +
            ", postalcode=" + postalcode +
            ", phone='" + phone + '\'' +
            ", isdefault=" + isdefault +
            ", userId=" + userId +
            '}';
    }
}
