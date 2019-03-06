package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.Menu;
import com.ecjtu.order.dao.MenuDao;
import com.ecjtu.order.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 菜单管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:52
 */
@Service
public class MenuServiceImpl implements MenuService
{
    @Autowired
    MenuDao menuDao;

    @Override
    public int deleteByPrimaryKey(Integer dishId)
    {
        return menuDao.deleteByPrimaryKey(dishId);
    }

    @Override
    public int insert(Menu menu)
    {
        return menuDao.insert(menu);
    }

    @Override
    public Menu selectByPrimaryKey(Integer dishId)
    {
        return menuDao.selectByPrimaryKey(dishId);
    }

    @Override
    public List<Menu> selectAll()
    {
        return menuDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Menu menu)
    {
        return menuDao.updateByPrimaryKey(menu);
    }

    @Override
    public List<Menu> selectMenus(Integer restaurId)
    {
        return menuDao.selectMenus(restaurId);
    }

    @Override
    public int[] selectRestaurId()
    {
        return menuDao.selectRestaurId();
    }

    @Override
    public List<Menu> selectByNC(String dishName, String dishClass)
    {
        return menuDao.selectByNC(dishName, dishClass);
    }
}
