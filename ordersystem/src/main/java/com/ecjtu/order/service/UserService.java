package com.ecjtu.order.service;

import com.ecjtu.order.bean.User;
import com.ecjtu.order.common.PageHelper;

import java.util.List;

/**
 * Desc: 用户信息管理service
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service
 * ProjectName: order
 * Date: 2019/2/14 20:39
 */
public interface UserService
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
     * 查询所有用户信息并分页
     *
     * @param user 用户实体对象
     * @return 用户信息封装类
     */
    PageHelper<User> selectAll(User user);

    /**
     * 根据id修改用户信息
     *
     * @param email 邮箱
     * @param phone 电话
     * @param sex   性别
     * @param id    用户id
     * @return 整数
     */
    Integer updateByPrimaryKey(String email, String phone, String sex, Integer id);

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
    User selectUsername(String userName, String userPwd);

    /**
     * 更新数据库中的图片名
     *
     * @param id  用户id
     * @param pic 头像
     * @return 整数
     */
    Integer updatePic(Integer id, String pic);

    /**
     * 根据id修改密码
     *
     * @param id  用户id
     * @param pwd 密码
     * @return 整数
     */
    Integer updatePwd(Integer id, String pwd);

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
    List<User> selectByName(String userName);

    /**
     * 查询用户总数
     *
     * @param user 用户实体
     * @return 用户总数
     */
    Integer queryTotal(User user);
}
