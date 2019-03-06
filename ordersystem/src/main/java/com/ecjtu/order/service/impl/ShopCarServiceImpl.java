package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.ShopCar;
import com.ecjtu.order.dao.ShopCarDao;
import com.ecjtu.order.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 购物车管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:57
 */
@Service
public class ShopCarServiceImpl implements ShopCarService
{
    @Autowired
    ShopCarDao shopCarDao;

    @Override
    public int deleteByPrimaryKey(Integer shopcarId)
    {
        return shopCarDao.deleteByPrimaryKey(shopcarId);
    }

    @Override
    public int insert(ShopCar shopcar)
    {
        return shopCarDao.insert(shopcar);
    }

    @Override
    public ShopCar selectByPrimaryKey(Integer shopcarId)
    {
        return shopCarDao.selectByPrimaryKey(shopcarId);
    }

    @Override
    public List<ShopCar> selectAll()
    {
        return shopCarDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ShopCar shopcar)
    {
        return shopCarDao.updateByPrimaryKey(shopcar);
    }

    @Override
    public List<ShopCar> selectShops(Integer userId)
    {
        return shopCarDao.selectShops(userId);
    }

    @Override
    public int calcuPric(Integer userId)
    {
        return shopCarDao.calcuPric(userId);
    }

    @Override
    public int deleteAllShop(Integer userId)
    {
        return shopCarDao.deleteAllShop(userId);
    }
}
