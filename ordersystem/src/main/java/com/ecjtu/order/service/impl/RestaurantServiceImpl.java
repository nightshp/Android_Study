package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.Restaurant;
import com.ecjtu.order.dao.RestaurantDao;
import com.ecjtu.order.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 餐厅管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:55
 */
@Service
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
    RestaurantDao restaurantDao;

    @Override
    public int deleteByPrimaryKey(Integer restaurId)
    {
        return restaurantDao.deleteByPrimaryKey(restaurId);
    }

    @Override
    public int insert(Restaurant restaurant)
    {
        return restaurantDao.insert(restaurant);
    }

    @Override
    public Restaurant selectByPrimaryKey(Integer restaurId)
    {
        return restaurantDao.selectByPrimaryKey(restaurId);
    }

    @Override
    public List<Restaurant> selectAll()
    {
        return restaurantDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Restaurant restaurant)
    {
        return restaurantDao.updateByPrimaryKey(restaurant);
    }

    @Override
    public List<Restaurant> selectByNA(String restaurName, String restaurAddress)
    {
        return restaurantDao.selectByNA(restaurName, restaurAddress);
    }

    @Override
    public List<Restaurant> selectByMany(String restaurName, String restaurAddress)
    {
        return restaurantDao.selectByMany(restaurName, restaurAddress);
    }
}
