package com.hdjd.order.bean;

import org.springframework.stereotype.Repository;

/**
 * Desc: TODO
 * <p>
 * Author: suhongpeng
 * PackageName: com.hdjd.order.bean
 * ProjectName: order
 * Date: 2019/2/15 11:22
 */
public class User
{
    private Integer uId;

    private String uName;

    private String uPassword;

    public Integer getuId()
    {
        return uId;
    }

    public void setuId(Integer uId)
    {
        this.uId = uId;
    }

    public String getuName()
    {
        return uName;
    }

    public void setuName(String uName)
    {
        this.uName = uName;
    }

    public String getuPassword()
    {
        return uPassword;
    }

    public void setuPassword(String uPassword)
    {
        this.uPassword = uPassword;
    }

    @Override
    public String toString()
    {
        return "User{" +
            "uId=" + uId +
            ", uName='" + uName + '\'' +
            ", uPassword='" + uPassword + '\'' +
            '}';
    }
}
