package com.ecjtu.order.bean;

/**
 * Desc: 管理员实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/15 20:09
 */
public class Admin
{
    /**
     * id
     */
    private Integer adminId;

    /**
     * 密码
     */
    private String adminPassword;

    /**
     * 用户名
     */
    private String adminName;

    /**
     * 电话
     */
    private String adminPhone;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    @Override
    public String toString()
    {
        return "Admin{" +
            "adminId=" + adminId +
            ", adminPassword='" + adminPassword + '\'' +
            ", adminName='" + adminName + '\'' +
            ", adminPhone='" + adminPhone + '\'' +
            '}';
    }
}
