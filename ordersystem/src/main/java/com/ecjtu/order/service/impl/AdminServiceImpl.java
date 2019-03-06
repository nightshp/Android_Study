package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.Admin;
import com.ecjtu.order.dao.AdminDao;
import com.ecjtu.order.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 管理员信息管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:48
 */
@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    AdminDao adminDao;

    @Override
    public int deleteByPrimaryKey(Integer adminId)
    {
        return adminDao.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insert(Admin admin)
    {
        return adminDao.insert(admin);
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminId)
    {
        return adminDao.selectByPrimaryKey(adminId);
    }

    @Override
    public List<Admin> selectAll()
    {
        return adminDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Admin admin)
    {
        return adminDao.updateByPrimaryKey(admin);
    }

    @Override
    public Admin selectByAP(String adminName, String adminPassword)
    {
        return adminDao.selectByAP(adminName, adminPassword);
    }
}
