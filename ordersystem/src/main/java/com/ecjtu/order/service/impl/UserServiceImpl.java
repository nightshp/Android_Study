package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.User;
import com.ecjtu.order.common.PageHelper;
import com.ecjtu.order.dao.UserDao;
import com.ecjtu.order.service.UserService;
import com.ecjtu.order.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 用户信息管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/14 20:40
 */
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UserDao userDao;

    @Override
    public Integer deleteByPrimaryKey(Integer userId)
    {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer insert(User user)
    {
        if (user != null && !StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getUserPwd()))
        {
            // MD5对密码进行加密
            user.setUserPwd(MD5Util.md5(user.getUserPwd()));
            return userDao.insert(user);
        }
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userId)
    {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public PageHelper<User> selectAll(User user)
    {
        System.out.println(user.getUserName());
        System.out.println("offset:" + user.getOffset() + "pageSize:" + user.getPageSize());
        // 查询结果集
        List<User> users = userDao.selectAll(user);
        System.out.println(users);
        PageHelper<User> helper = new PageHelper<User>();
        helper.setRows(users);
        // 查询用户总数
        Integer total = userDao.queryTotal(user);
        helper.setTotal(total);

        return helper;
    }

    @Override
    public Integer updateByPrimaryKey(String email, String phone, String sex, Integer id)
    {
        return userDao.updateByPrimaryKey(email, phone, sex, id);
    }

    @Override
    public Integer updateUsers(User user)
    {
        return userDao.updateUsers(user);
    }

    @Override
    public User selectUsername(String userName, String userPwd)
    {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(userPwd))
        {
            // 利用加密后的密码查询
            String pwd = MD5Util.md5(userPwd);
            return userDao.selectUsername(userName, pwd);
        }
        return null;
    }

    @Override
    public Integer updatePic(Integer id, String pic)
    {
        return userDao.updatePic(id, pic);
    }

    @Override
    public Integer updatePwd(Integer id, String pwd)
    {
        return userDao.updatePwd(id, pwd);
    }

    @Override
    public Integer updateUserinfo(User user)
    {
        return userDao.updateUserinfo(user);
    }

    @Override
    public List<User> selectByName(String userName)
    {
        return userDao.selectByName(userName);
    }

    @Override
    public Integer queryTotal(User user)
    {
        return userDao.queryTotal(user);
    }
}
