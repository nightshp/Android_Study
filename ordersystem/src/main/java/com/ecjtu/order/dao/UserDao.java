package com.ecjtu.order.dao;

import com.ecjtu.order.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desc: 用户信息dao
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.dao
 * ProjectName: order
 * Date: 2019/2/14 20:22
 */
@Mapper
public interface UserDao
{
    /**
     * 根据id删除用户
     *
     * @param userId 用户id
     * @return 整数
     */
    Integer deleteByPrimaryKey(Integer userId);

    /**
     * 插入用户信息
     *
     * @param user 用户对象
     * @return 整数
     */
    Integer insert(User user);

    /**
     * 根据id查找用户信息
     *
     * @param userId 用户id
     * @return 用户对象
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 查询所有用户信息
     *
     * @return 用户信息集合
     */
    List<User> selectAll(User user);

    /**
     * 根据id修改用户信息
     *
     * @param email 邮箱
     * @param phone 电话
     * @param sex   性别
     * @param id    用户id
     * @return 整数
     */
    Integer updateByPrimaryKey(@Param("email") String email, @Param("phone") String phone, @Param("sex") String sex,
        @Param("userId") Integer id);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return 整数
     */
    Integer updateUsers(User user);

    /**
     * 根据用户名和密码查询用户
     *
     * @param userName 用户名
     * @param userPwd  密码
     * @return 用户对象信息
     */
    User selectUsername(@Param("userName") String userName, @Param("userPwd") String userPwd);

    /**
     * 更新数据库中的图片名
     *
     * @param id  用户id
     * @param pic 头像
     * @return 整数
     */
    Integer updatePic(@Param("userId") Integer id, @Param("pic") String pic);

    /**
     * 根据id修改密码
     *
     * @param id  用户id
     * @param pwd 密码
     * @return 整数
     */
    Integer updatePwd(@Param("userId") Integer id, @Param("userPwd") String pwd);

    /**
     * 修改信息包括图片上传
     *
     * @param user 用户对象
     * @return 整数
     */
    Integer updateUserinfo(User user);

    /**
     * 根据用户名实现搜索功能
     *
     * @param userName 用户名
     * @return 用户对象集合
     */
    List<User> selectByName(@Param("userName") String userName);

    /**
     * 查询用户总数
     *
     * @param user 用户实体
     * @return 用户总数
     */
    Integer queryTotal(User user);

}
