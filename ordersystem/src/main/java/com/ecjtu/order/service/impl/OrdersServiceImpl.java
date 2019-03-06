package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.Orders;
import com.ecjtu.order.dao.OrdersDao;
import com.ecjtu.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 订单管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:53
 */
@Service
public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    OrdersDao ordersDao;

    @Override
    public int deleteByPrimaryKey(Integer orderId)
    {
        return ordersDao.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Orders orders)
    {
        return ordersDao.insert(orders);
    }

    @Override
    public Orders selectByPrimaryKey(Integer orderId)
    {
        return ordersDao.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Orders> selectAll(Integer userId)
    {
        return ordersDao.selectAll(userId);
    }

    @Override
    public int updateByPrimaryKey(Orders orders)
    {
        return ordersDao.updateByPrimaryKey(orders);
    }

    @Override
    public List<Orders> selectall()
    {
        return ordersDao.selectall();
    }
}
