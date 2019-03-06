package com.ecjtu.order.bean;

import com.ecjtu.order.common.PageInfos;

/**
 * Desc: 用户实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.bean
 * ProjectName: ordersystem
 * Date: 2019/2/14 20:16
 */
public class User extends PageInfos
{
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String pic;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserPwd()
    {
        return userPwd;
    }

    public void setUserPwd(String userPwd)
    {
        this.userPwd = userPwd;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getPic()
    {
        return pic;
    }

    public void setPic(String pic)
    {
        this.pic = pic;
    }

    @Override
    public String toString()
    {
        return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", sex='" + sex + '\'' +
            ", pic='" + pic + '\'' +
            '}';
    }
}
