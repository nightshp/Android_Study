package com.hdjd.order.service.impl;

import com.hdjd.order.bean.User;
import com.hdjd.order.dao.UserDao;
import com.hdjd.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: suhongpeng
 * PackageName: com.hdjd.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 11:25
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryAllUser()
    {
        return userDao.queryAllUser();
    }
}
