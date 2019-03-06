package com.ecjtu.order.bean;

/**
 * Desc: 菜单实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:09
 */
public class Menu
{
    /**
     * 菜肴id
     */
    private Integer dishId;

    /**
     * 菜肴名字
     */
    private String dishName;

    /**
     * 价格
     */
    private Integer dishPric;

    /**
     * 描述
     */
    private String dishDiscribe;

    /**
     * 类别
     */
    private String dishClass;

    /**
     * 图片
     */
    private String dishPic;

    /**
     * 所属餐馆id
     */
    private Integer restaurId;

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName == null ? null : dishName.trim();
    }

    public Integer getDishPric() {
        return dishPric;
    }

    public void setDishPric(Integer dishPric) {
        this.dishPric = dishPric;
    }

    public String getDishDiscribe() {
        return dishDiscribe;
    }

    public void setDishDiscribe(String dishDiscribe) {
        this.dishDiscribe = dishDiscribe == null ? null : dishDiscribe.trim();
    }

    public String getDishClass() {
        return dishClass;
    }

    public void setDishClass(String dishClass) {
        this.dishClass = dishClass == null ? null : dishClass.trim();
    }

    public String getDishPic() {
        return dishPic;
    }

    public void setDishPic(String dishPic) {
        this.dishPic = dishPic == null ? null : dishPic.trim();
    }

    public Integer getRestaurId() {
        return restaurId;
    }

    public void setRestaurId(Integer restaurId) {
        this.restaurId = restaurId;
    }

    @Override
    public String toString() {
        return "Menu{" +
            "dishId=" + dishId +
            ", dishName='" + dishName + '\'' +
            ", dishPric=" + dishPric +
            ", dishDiscribe='" + dishDiscribe + '\'' +
            ", dishClass='" + dishClass + '\'' +
            ", dishPic='" + dishPic + '\'' +
            ", restaurId=" + restaurId +
            '}';
    }
}
