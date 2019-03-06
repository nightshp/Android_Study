package com.ecjtu.order.bean;

/**
 * Desc: 购物车实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:10
 */
public class ShopCar
{

    /**
     * id
     */
    private Integer shopcarId;

    /**
     * 名字
     */
    private String shopName;

    /**
     * 图片
     */
    private String shopPic;

    /**
     * 价格
     */
    private Integer shopPrice;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 描述
     */
    private String shopDescribe;

    public Integer getShopcarId() {
        return shopcarId;
    }

    public void setShopcarId(Integer shopcarId) {
        this.shopcarId = shopcarId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic == null ? null : shopPic.trim();
    }

    public Integer getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Integer shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShopDescribe() {
        return shopDescribe;
    }

    public void setShopDescribe(String shopDescribe) {
        this.shopDescribe = shopDescribe;
    }

    @Override
    public String toString()
    {
        return "ShopCar{" +
            "shopcarId=" + shopcarId +
            ", shopName='" + shopName + '\'' +
            ", shopPic='" + shopPic + '\'' +
            ", shopPrice=" + shopPrice +
            ", userId=" + userId +
            ", shopDescribe='" + shopDescribe + '\'' +
            '}';
    }
}
