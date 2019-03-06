package com.ecjtu.order.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Desc: MD5加密工具类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.util
 * ProjectName: ordersystem
 * Date: 2019/2/20 16:24
 */
public class MD5Util
{
    /**
     * 对输入的密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    public static String md5(String password)
    {
        MessageDigest md;
        try
        {
            //利用哈希算法，MD5
            md = MessageDigest.getInstance("MD5");
            //面向字节处理，所以可以处理字节的东西，如图片，压缩包。。
            byte[] input = password.getBytes();
            byte[] output = md.digest(input);
            //将md5处理后的output结果利用Base64转成原有的字符串,不会乱码
            String str = Base64.encodeBase64String(output);
            return str;
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("密码加密失败");
            return "";
        }
    }

}
